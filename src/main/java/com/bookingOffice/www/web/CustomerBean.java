package com.bookingOffice.www.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.services.CustomerService;
import com.bookingOffice.www.util.CartTickets;

@Named
@Scope("session")
public class CustomerBean {
	private Person customer;
	private List<Flight> flights = null;
	private Flight flight = null;
	private List<CartTickets> tickets = new ArrayList<>();
	private Date arrivalTime = new Date();
	@Inject
	private CustomerService customerService;

	public String getFlightsFiltered() {
		flight.setArrivalTime(this.arrivalTime);
		flights = customerService.getFlightsFiltered(flight);
		return "CustomerResult";
	}

	public CustomerBean() {
		customer = new Person();
		//TODO Get REAL person
		customer.setId(1);
		flight = new Flight();
		flight.setDeparture("KBP");
		flight.setArrival("JFK");
	}

	public String addTicketToCart(Flight flight) {
		CartTickets ticket = new CartTickets(flight);
		tickets.add(ticket);
		return "CustomerResult";
	}
	
	public String removeTicket(CartTickets ticket) {
		tickets.remove(ticket);
		return "CustomerCart";
	}
	
	public String submitCart() {
		ArrayList<Ticket> pureTickets = new ArrayList<Ticket>();
		for (CartTickets cartTickets : tickets) {
			pureTickets.add(new Ticket(cartTickets));
		}
		customerService.submitCart(pureTickets, customer);
		return "CustomerResult";
	}
	

	/**
	 * @return the flights
	 */
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

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight
	 *            the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime
	 *            the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the tickets
	 */
	public List<CartTickets> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<CartTickets> tickets) {
		this.tickets = tickets;
	}

	/**
	 * @return the customer
	 */
	public Person getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Person customer) {
		this.customer = customer;
	}


}
