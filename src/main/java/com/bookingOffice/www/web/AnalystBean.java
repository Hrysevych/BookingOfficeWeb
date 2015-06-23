package com.bookingOffice.www.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

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

	public String refreshReports() {
		totalReport = analystService.getTotalReport(from, until);
		reports = analystService.getDailyReports(from, until);
		return "Analyst";
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

}
