package com.bookingOffice.www.services;

import java.util.List;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.Ordering;

public interface AdministratorService {

	public Flight getFlight(int id);
	
	public List<Flight> getFlights();
	
	public List<Ordering> getInvalidOrderings();

	public void addFlight(Flight flight);
	
	public void updateFlight(int id, Flight flight);

	public void addTickets(int id, int quantity);

	public void subtractTickets(int id, int quantity);
	
	public void releaseUnpaidTickets();
	
	public void deleteFlight(int id);
}
