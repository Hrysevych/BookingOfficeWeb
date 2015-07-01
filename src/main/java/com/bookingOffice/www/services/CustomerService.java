package com.bookingOffice.www.services;

import java.util.List;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.Ticket;

public interface CustomerService {
	public List<Flight> getFlightsFiltered(Flight flight);

	public void submitCart(List<Ticket> tickets, int personId);

	public Flight getFlight(int id);

}
