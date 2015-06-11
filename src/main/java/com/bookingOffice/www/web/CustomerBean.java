package com.bookingOffice.www.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.services.CustomerService;

@Named
@Scope("session")
public class CustomerBean {
	private List<Flight> flights = null;
	public Flight flight = null;
	@Inject
	private CustomerService customerService;

	public String getFlightsFiltered() {
		flights = customerService.getFlightsFiltered(flight);
		return "CustomerResult";
	}

	
	public CustomerBean() {
		flight = new Flight();
	}


	/**
	 * @return the flights
	 */
	public List<Flight> getFlights() {
		return flights;
	}

	/**
	 * @param flights the flights to set
	 */
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}



}
