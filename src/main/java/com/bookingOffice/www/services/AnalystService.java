package com.bookingOffice.www.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.bookingOffice.www.util.SellsReport;

public interface AnalystService {

	public SellsReport getTotalReport(Date from, Date until);

	public List<SellsReport> getDailyReports(Date from, Date until);

	public SellsReport getTotalReport(LocalDate from, LocalDate until);

	public List<SellsReport> getDailyReports(LocalDate from, LocalDate until);

}
