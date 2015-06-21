package com.bookingOffice.www.DAO;

import java.sql.Date;
import java.util.List;

import com.bookingOffice.www.util.SellsReport;

public interface OrderDAO {
	
	public void addOrdering(Order ordering);
	
	public void deleteOrdering(int id);
	
	public Order getOrdering(int id);

	public void setOrderingPayed(int id);

	public List<Order> getUnpaidValidOrderings();

	public List<Order> getInvalidOrderings();
	
	public List<Order> getAllOrderings();
	
	public List<Order> getOrderingsByDates(Date from, Date until);
	
	public SellsReport getTotalReport(Date from, Date until);
	
	public List<SellsReport> getDailyReports(Date from, Date until);
	

}
