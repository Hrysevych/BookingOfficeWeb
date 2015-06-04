package com.bookingOffice.www.services;

import java.sql.Date;
import java.util.ArrayList;



import com.bookingOffice.www.util.SellsReport;

public interface AnalyticService {

	public SellsReport getTotalReport(Date from, Date until);
	
	public ArrayList<SellsReport> getDailyReports(Date from, Date until);
	
	
}
