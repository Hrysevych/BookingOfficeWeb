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
	private List<CartTickets> cart = new ArrayList<>();
	private Date arrivalTime = new Date();
	@Inject
	private CustomerService customerService;

	public String getFlightsFiltered() {
		flight.setArrivalTime(this.arrivalTime);
		flights = customerService.getFlightsFiltered(flight);
		return "Customer";
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
		cart.add(ticket);
		return "Customer";
	}
	
	public String removeTicket(CartTickets ticket) {
		cart.remove(ticket);
		return "Cart";
	}
	
	public String submitCart() {
		ArrayList<Ticket> pureTickets = new ArrayList<Ticket>();
		for (CartTickets cartTickets : cart) {
			pureTickets.add(new Ticket(cartTickets));
		}
		customerService.submitCart(pureTickets, customer);
		return "Customer";
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

	/**
	 * @return the cart
	 */
	public List<CartTickets> getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(List<CartTickets> cart) {
		this.cart = cart;
	}


}
