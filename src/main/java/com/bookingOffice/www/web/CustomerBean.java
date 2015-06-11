package com.bookingOffice.www.web;

import java.util.Date;
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
	private Flight flight = null;
	private java.util.Date arrivalTime = new Date(); 
	@Inject
	private CustomerService customerService;

	public String getFlightsFiltered() {
		flight.setArrivalTime(this.arrivalTime);
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


	/**
	 * @return the arrivalTime
	 */
	public java.util.Date getArrivalTime() {
		return arrivalTime;
	}


	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(java.util.Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}



}
