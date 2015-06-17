package com.bookingOffice.www.DAO;

import java.util.List;

public interface FlightDAO {
	public Flight getFlight(int id);

	public void addFlight(Flight flight);

	public void updateFlight(int id, Flight flight);

	public void deleteFlight(int id);

	public void editTicketsNumber(int id, int quantity);

	public List<Flight> getFlightsFiltered(Flight flight);
	
	public List<Flight> getFlights();

	public List<Flight> getFlightsForCart(List<Ticket> cart);
}
