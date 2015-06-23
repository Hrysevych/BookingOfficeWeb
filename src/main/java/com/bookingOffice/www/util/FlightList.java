package com.bookingOffice.www.util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.bookingOffice.www.DAO.Flight;

@XmlRootElement
public class FlightList {
	private List<Flight> flights;

	/**
	 * 
	 */
	public FlightList() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the flights
	 */
	@XmlElementWrapper(name = "flightsList")
	@XmlElement(name = "flight", type = Flight.class)
	public List<Flight> getFlights() {
		return flights;
	}

	/**
	 * @param flights
	 *            the flights to set
	 */
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
