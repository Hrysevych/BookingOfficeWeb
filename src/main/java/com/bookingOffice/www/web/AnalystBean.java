package com.bookingOffice.www.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.services.AnalystService;
import com.bookingOffice.www.util.SellsReport;

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

	private LineChartModel model = new LineChartModel();

	public String refreshReports() {
		totalReport = analystService.getTotalReport(from, until);
		reports = analystService.getDailyReports(from, until);
		createModel();
		return "Analyst";
	}

	private void createModel() {

		LineChartSeries tickets = new LineChartSeries();
		tickets.setLabel("Tickets");
		tickets.setXaxis(AxisType.X);
		tickets.setYaxis(AxisType.Y);

		LineChartSeries sums = new LineChartSeries();
		sums.setLabel("Sum");
		sums.setXaxis(AxisType.X);
		sums.setYaxis(AxisType.Y2);

		double maxSum = 0;
		int maxTickets = 0;
		for (SellsReport sellsReport : reports) {
			tickets.set(sellsReport.getDate(), sellsReport.getTicketsQuantity());
			sums.set(sellsReport.getDate(), sellsReport.getTotalSum());
			if (sellsReport.getTotalSum() > maxSum) {
				maxSum = sellsReport.getTotalSum();
			}
			if (sellsReport.getTicketsQuantity() > maxTickets) {
				maxTickets = sellsReport.getTicketsQuantity();
			}
		}

		model.addSeries(tickets);
		model.addSeries(sums);

		model.setTitle("Reports");
		model.setMouseoverHighlight(false);

		model.getAxes().put(AxisType.X, new DateAxis("Dates"));

		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("Tickets sold");
		yAxis.setMin(0);
		yAxis.setMax(maxTickets);

		Axis y2Axis = new LinearAxis("Sum");
		y2Axis.setMin(0);
		y2Axis.setMax(maxSum);

		model.getAxes().put(AxisType.Y2, y2Axis);
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
	 * @param model the model to set
	 */
	public void setModel(LineChartModel model) {
		this.model = model;
	}


}
