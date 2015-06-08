package com.bookingOffice.www;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.services.AdministratorService;

@Named
@Scope("session")
public class CustomerBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7123610664654371778L;
	private List<Flight> flights = null;
	private Flight flight = null;
	/*@Inject
	private CustomerService customerService;*/
	@Inject
	private AdministratorService administratorService;

	public void refreshList() {
		flights = administratorService.getFlights();
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
