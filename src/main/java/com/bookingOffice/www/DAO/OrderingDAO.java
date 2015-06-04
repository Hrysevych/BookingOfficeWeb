package com.bookingOffice.www.DAO;

import java.sql.Date;
import java.util.List;

import com.bookingOffice.www.util.SellsReport;

public interface OrderingDAO {
	
	public void addOrdering(Ordering ordering);
	
	public void deleteOrdering(int id);
	
	public Ordering getOrdering(int id);

	public void setOrderingPayed(int id);

	public List<Ordering> getValidOrderings();

	public List<Ordering> getInvalidOrderings();
	
	public List<Ordering> getAllOrderings();
	
	public List<Ordering> getOrderingsByDates(Date from, Date until);
	
	public SellsReport getTotalReport(Date from, Date until);
	
	public List<SellsReport> getDailyReports(Date from, Date until);
	

}
