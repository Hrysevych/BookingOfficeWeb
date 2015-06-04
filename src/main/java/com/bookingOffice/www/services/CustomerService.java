package com.bookingOffice.www.services;

import java.util.List;

import javax.management.AttributeList;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.Person;

public interface CustomerService {
	public List<Flight> getFlightsFiltered(Flight flight);
	
	public void submitCart(Person person);
	
	public void addTicket(Person person, Flight flight);
	
	public void removeTicket(Person person, int index);
	
	public AttributeList getCartReport(Person person);
}
