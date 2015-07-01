package com.bookingOffice.www.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.services.AnalystService;
import com.bookingOffice.www.util.CitiesList;
import com.bookingOffice.www.util.SellsReport;
import com.bookingOffice.www.util.ValidityDurationUtil;

@Named
@Scope("session")
public class AnalystBean {
	@Inject
	private AnalystService analystService;

	private Date from;
	private Date until;

	private List<SellsReport> reports = null;
	private SellsReport totalReport = null;
	private SellsReport report = null;

	private Map<String, String> cities = new CitiesList().getCities();

	private String type = "";

	private LineChartModel model;

	public String getCityFromCode(String code) {
		for (Map.Entry<String, String> city : cities.entrySet()) {
			if (city.getValue().equals(code))
				return city.getKey();
		}
		return "";
	}

	public String refreshReportsByDates() {
		totalReport = analystService.getTotalReport(from, until);
		reports = analystService.getDailyReportsByDates(from, until);
		type = "dates";
		createModel();
		return "Analyst";
	}

	public String refreshReportsByDestinations() {
		totalReport = analystService.getTotalReport(from, until);
		reports = analystService.getDailyReportsByDestinations(from, until);
		type = "destinations";
		createModel();
		return "Analyst";
	}

	public String formatDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		String formatted = dateFormat.format(date).toString();
		return formatted;
	}

	private void createModel() {
		model = new LineChartModel();
		model.setLegendPosition("e");
		if (type.equals("dates")) {
			LineChartSeries ticketsByDates = new LineChartSeries();
			ticketsByDates.setLabel("Tickets");
			ticketsByDates.setXaxis(AxisType.X);
			ticketsByDates.setYaxis(AxisType.Y);

			LineChartSeries sumsByDates = new LineChartSeries();
			sumsByDates.setLabel("Sum");
			sumsByDates.setXaxis(AxisType.X);
			sumsByDates.setYaxis(AxisType.Y2);

			double maxSum = 0;
			int maxTickets = 0;
			Date minDate = until;
			Date maxDate = from;

			for (SellsReport sellsReport : reports) {
				ticketsByDates.set(formatDate(sellsReport.getDate()),
						sellsReport.getTicketsQuantity());
				sumsByDates.set(formatDate(sellsReport.getDate()),
						sellsReport.getTotalSum());

				if (sellsReport.getTotalSum() > maxSum) {
					maxSum = sellsReport.getTotalSum();
				}

				if (sellsReport.getTicketsQuantity() > maxTickets) {
					maxTickets = sellsReport.getTicketsQuantity();
				}

				if (sellsReport.getDate().before(minDate)) {
					minDate = sellsReport.getDate();
				}

				if (sellsReport.getDate().after(maxDate)) {
					maxDate = sellsReport.getDate();
				}
			}

			minDate = ValidityDurationUtil.toNormalDate(minDate);

			maxDate = ValidityDurationUtil.toValidDate(maxDate);

			maxTickets *= 1.25;
			maxTickets += 1;

			maxSum *= 1.25;
			maxSum += 10;

			model.addSeries(ticketsByDates);
			model.addSeries(sumsByDates);

			model.setTitle("Reports");
			DateAxis xAxis = new DateAxis("Dates");
			xAxis.setMin(formatDate(minDate));
			xAxis.setMax(formatDate(maxDate));
			xAxis.setTickFormat("%#d %b %y");
			model.getAxes().put(AxisType.X, xAxis);

			Axis yAxis = model.getAxis(AxisType.Y);
			yAxis.setLabel("Tickets sold");
			yAxis.setMin(0);
			yAxis.setMax(maxTickets);

			Axis y2Axis = new LinearAxis("Sum");
			y2Axis.setMin(0);
			y2Axis.setMax(maxSum);
			model.getAxes().put(AxisType.Y2, y2Axis);
		}

		if (type.equals("destinations")) {
			LineChartSeries ticketsByDestinations = new LineChartSeries(
					"Tickets");
			ticketsByDestinations.setXaxis(AxisType.X);
			ticketsByDestinations.setYaxis(AxisType.Y);

			LineChartSeries sumsByDestinations = new LineChartSeries();
			sumsByDestinations.setLabel("Sum");
			sumsByDestinations.setXaxis(AxisType.X);
			sumsByDestinations.setYaxis(AxisType.Y2);

			for (SellsReport sellsReport : reports) {
				ticketsByDestinations.set(
						getCityFromCode(sellsReport.getDestination()),
						sellsReport.getTicketsQuantity());
				sumsByDestinations.set(
						getCityFromCode(sellsReport.getDestination()),
						sellsReport.getTotalSum());
			}

			model.addSeries(ticketsByDestinations);
			model.addSeries(sumsByDestinations);

			model.setTitle("Reports");
			CategoryAxis xAxis = new CategoryAxis("Destinations");
			model.getAxes().put(AxisType.X, xAxis);

			Axis yAxis = model.getAxis(AxisType.Y);
			yAxis.setLabel("Tickets sold");

			Axis y2Axis = new LinearAxis("Sum");
			model.getAxes().put(AxisType.Y2, y2Axis);
		}

	}

	public AnalystBean() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -1);
		from = calendar.getTime();
		calendar.add(Calendar.YEAR, 2);
		until = calendar.getTime();
		report = new SellsReport();
		totalReport = new SellsReport();
	}

	/**
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(Date from) {
		this.from = from;
	}

	/**
	 * @return the until
	 */
	public Date getUntil() {
		return until;
	}

	/**
	 * @param until
	 *            the until to set
	 */
	public void setUntil(Date until) {
		this.until = until;
	}

	/**
	 * @return the reports
	 */
	public List<SellsReport> getReports() {
		return reports;
	}

	/**
	 * @param reports
	 *            the reports to set
	 */
	public void setReports(List<SellsReport> reports) {
		this.reports = reports;
	}

	/**
	 * @return the totalReport
	 */
	public SellsReport getTotalReport() {
		return totalReport;
	}

	/**
	 * @param totalReport
	 *            the totalReport to set
	 */
	public void setTotalReport(SellsReport totalReport) {
		this.totalReport = totalReport;
	}

	/**
	 * @return the report
	 */
	public SellsReport getReport() {
		return report;
	}

	/**
	 * @param report
	 *            the report to set
	 */
	public void setReport(SellsReport report) {
		this.report = report;
	}

	/**
	 * @return the model
	 */
	public LineChartModel getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(LineChartModel model) {
		this.model = model;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the cities
	 */
	public Map<String, String> getCities() {
		return cities;
	}

	/**
	 * @param cities
	 *            the cities to set
	 */
	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

}
