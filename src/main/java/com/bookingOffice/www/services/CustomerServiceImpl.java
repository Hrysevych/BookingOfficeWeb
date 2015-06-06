package com.bookingOffice.www.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.management.Attribute;
import javax.management.AttributeList;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.DAO.TicketDAO;
import com.bookingOffice.www.util.FlightError;

@Named
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private FlightDAO flightDAO;
	@Inject
	private TicketDAO ticketDAO;

	public List<Flight> getFlightsFiltered(Flight flight) {
		return flightDAO.getFlightsFiltered(flight);
	}

	public void addTicket(Person person, Flight flight) {
		Ticket ticket = new Ticket();
		ticket.setBuyerId(person.getId());
		ticket.setFlightID(flight.getId());
		if (flight.getTicketsAvailable() > 0) {
			person.addTicketToCart(ticket);
		} else {
			throw new FlightError("Ticket is not available");
		}
	}

	public void removeTicket(Person person, int index) {
		person.removeTicketFromCart(index);

	}

	public void submitCart(Person person) {
		ArrayList<Ticket> cart = person.getCart();
		for (Ticket ticket : cart) {
			ticketDAO.addTicket(ticket);
		}

	}

	public AttributeList getCartReport(Person person) {
		int quantity = 0;
		double total = 0.;
		for (Ticket ticket : person.getCart()) {
			quantity++;
			total += flightDAO.getFlight(ticket.getFlightID()).getTicketPrice();
		}
		AttributeList list = new AttributeList();
		list.add(new Attribute("Quantity", quantity));
		list.add(new Attribute("Total", total));
		return list;
	}
}
