package com.bookingOffice.www.web;

import java.time.LocalDate;
import java.util.ArrayList;
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

	private Date from = java.sql.Date.valueOf(LocalDate.now().minusYears(1));
	private Date until = java.sql.Date.valueOf(LocalDate.now().plusYears(1));

	private List<SellsReport> reports = null;
	private SellsReport totalReport = null;
	private SellsReport report = null;
	@Inject
	private AnalystService analystService;

	public String refreshReports() {
		totalReport = analystService.getTotalReport(from, until);
		reports = analystService.getDailyReports(from, until);
		return "Analyst";
	}

	public AnalystBean() {
		report = new SellsReport();
		totalReport = new SellsReport();
		reports = new ArrayList<SellsReport>();
	}

	/**
	 * @return the from
	 */
	public Date getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
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
	 * @param until the until to set
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
	 * @param reports the reports to set
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
	 * @param totalReport the totalReport to set
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
	 * @param report the report to set
	 */
	public void setReport(SellsReport report) {
		this.report = report;
	}

}
