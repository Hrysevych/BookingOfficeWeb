package com.bookingOffice.www.services;

import java.util.Date;
import java.util.List;

import com.bookingOffice.www.util.SellsReport;

public interface AnalystService {

	public SellsReport getTotalReport(Date from, Date until);

	public List<SellsReport> getDailyReportsByDates(Date from, Date until);
	
	public List<SellsReport> getDailyReportsByDestinations(Date from, Date until);

}
