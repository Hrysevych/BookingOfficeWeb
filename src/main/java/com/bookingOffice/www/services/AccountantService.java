package com.bookingOffice.www.services;

import java.util.List;

import com.bookingOffice.www.DAO.Ordering;


public interface AccountantService {
	
	public void markOrderingSold(int orderId);
	
	public void markTicketSold(int id);

	public List<Ordering> findOrderingsNotExpired();
}
