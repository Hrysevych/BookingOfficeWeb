package com.bookingOffice.www.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.services.CustomerService;
import com.bookingOffice.www.util.CartTicket;
import com.bookingOffice.www.util.CitiesList;

@Named
@Scope("session")
public class CustomerBean {
	@Inject
	private CustomerService customerService;

	private Person customer;
	private List<Flight> flights = null;
	private Flight flight = null;
	private List<CartTicket> cart = new ArrayList<>();
	private String allDataMessage = "";
	private Date arrivalTime = new Date();
	private Map<String, String> cities = new CitiesList().getCities();

	public String getFlightsFiltered() {
		flight.setArrivalTime(this.arrivalTime);
		flights = customerService.getFlightsFiltered(flight);
		return "Customer";
	}

	public String getCartSum() {
		double sum = 0;
		for (CartTicket cartTicket : cart) {
			sum += cartTicket.getTicketPrice();
		}
		return String.valueOf(sum);
	}
	
	public boolean isAllDataSet() {
		boolean flag = true;
		for (CartTicket ticket : cart) {
			if ((ticket.getFirstName() == null || ticket.getFirstName()
					.isEmpty())
					|| (ticket.getLastName() == null || ticket.getLastName()
							.isEmpty())
					|| (ticket.getPassport() == null || ticket.getPassport()
							.isEmpty()))
				flag = false;
			if (!flag)
				return flag;
		}
		return flag;
	}

	public CustomerBean() {
		customer = new Person();
		// TODO Get REAL person
		customer.setId(2);
		flight = new Flight();
	}

	public String addTicketToCart(Flight flight) {
		CartTicket ticket = new CartTicket(flight);
		cart.add(ticket);
		return "Customer";
	}

	public String removeTicket(CartTicket ticket) {
		cart.remove(ticket);
		return "Cart";
	}

	public String submitCart() {
		if (!isAllDataSet()) {
			allDataMessage = "You need to fill all empty fields of all tickets in cart!";
			return "Cart";
		}
		allDataMessage = "";
		ArrayList<Ticket> pureTickets = new ArrayList<Ticket>();
		for (CartTicket cartTickets : cart) {
			pureTickets.add(new Ticket(cartTickets));
		}
		customerService.submitCart(pureTickets, customer);
		cart.clear();
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
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	/**
	 * @return the cart
	 */
	public List<CartTicket> getCart() {
		return cart;
	}

	/**
	 * @param cart
	 *            the cart to set
	 */
	public void setCart(List<CartTicket> cart) {
		this.cart = cart;
	}

	/**
	 * @return the allDataMessage
	 */
	public String getAllDataMessage() {
		return allDataMessage;
	}

	/**
	 * @param allDataMessage
	 *            the allDataMessage to set
	 */
	public void setAllDataMessage(String allDataMessage) {
		this.allDataMessage = allDataMessage;
	}

	/**
	 * @return the cities
	 */
	public Map<String, String> getCities() {
		return cities;
	}

	/**
	 * @param cities
	 *            the cities to set
	 */
	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

}
