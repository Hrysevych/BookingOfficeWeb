package com.bookingOffice.www.services;

import java.sql.Date;
import java.util.ArrayList;



import java.util.List;

import com.bookingOffice.www.util.SellsReport;

public interface AnalyticService {

	public SellsReport getTotalReport(Date from, Date until);
	
	public List<SellsReport> getDailyReports(Date from, Date until);
	
	
}
