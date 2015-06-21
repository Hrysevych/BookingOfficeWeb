package com.bookingOffice.www.web;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
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

	private List<SellsReport> sellsReports = null;
	private SellsReport sellsReport = null;
	
	private LocalDate from = LocalDate.now();
	private LocalDate until = LocalDate.MAX;
	
	
	public void refreshReports() {
		sellsReport = analystService.getTotalReport(from, until);
		sellsReports = analystService.getDailyReports(from, until);
	}

	
	
	public AnalystBean() {
		sellsReport = new SellsReport();
	}


	/**
	 * @return the sellsReports
	 */
	public List<SellsReport> getSellsReports() {
		return sellsReports;
	}


	/**
	 * @param sellsReports the sellsReports to set
	 */
	public void setSellsReports(List<SellsReport> sellsReports) {
		this.sellsReports = sellsReports;
	}


	/**
	 * @return the sellsReport
	 */
	public SellsReport getSellsReport() {
		return sellsReport;
	}


	/**
	 * @param sellsReport the sellsReport to set
	 */
	public void setSellsReport(SellsReport sellsReport) {
		this.sellsReport = sellsReport;
	}


	/**
	 * @return the from
	 */
	public LocalDate getFrom() {
		return from;
	}


	/**
	 * @param from the from to set
	 */
	public void setFrom(LocalDate from) {
		this.from = from;
	}


	/**
	 * @return the until
	 */
	public LocalDate getUntil() {
		return until;
	}


	/**
	 * @param until the until to set
	 */
	public void setUntil(LocalDate until) {
		this.until = until;
	}

}
