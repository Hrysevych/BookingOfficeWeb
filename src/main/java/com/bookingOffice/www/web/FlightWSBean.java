package com.bookingOffice.www.web;

import java.io.StringWriter;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.services.CustomerService;
import com.bookingOffice.www.util.FlightList;

@javax.jws.WebService(endpointInterface = "com.bookingOffice.www.WebService")
@Named
public class FlightWSBean implements FlightWS {
	@Inject
	CustomerService customerService;
	
	private FlightList flights = new FlightList();

	public FlightWSBean() {
	}

	public String getFlightList() {
		try {
			Flight flight = new Flight();
			flight.setDeparture("KBP");
			flight.setArrival("JFK");
			flight.setArrivalTime(Timestamp.valueOf("2015-07-01"));
			flights.setFlights(customerService.getFlightsFiltered(flight));
			JAXBContext context = JAXBContext.newInstance(FlightList.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(flights, stringWriter);
			String txt = stringWriter.toString();
			return txt;
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Flight getFlight(int id) {
		return customerService.getFlight(id);
	}

	/**
	 * @return the flights
	 */
	public FlightList getFlights() {
		return flights;
	}

	/**
	 * @param flights
	 *            the flights to set
	 */
	public void setFlights(FlightList flights) {
		this.flights = flights;
	}

}
