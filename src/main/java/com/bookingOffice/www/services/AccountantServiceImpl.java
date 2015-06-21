package com.bookingOffice.www.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.Order;
import com.bookingOffice.www.DAO.OrderDAO;
import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.DAO.PersonDAO;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.DAO.TicketDAO;
import com.bookingOffice.www.util.OrderAndPerson;

@Named
public class AccountantServiceImpl implements AccountantService {

	@Inject
	private FlightDAO flightDAO;
	@Inject
	private TicketDAO ticketDAO;
	@Inject
	private OrderDAO orderDAO;
	@Inject
	private PersonDAO personDAO;

	public void markTicketSold(int id) {
		Ticket ticket = ticketDAO.getTicket(id);
		Flight flight = flightDAO.getFlight(ticket.getFlightId());
		flight.setTicketsBooked(flight.getTicketsBooked() - 1);
		flight.setTicketsSold(flight.getTicketsSold() + 1);
		flightDAO.addFlight(flight);
	}

	public void markOrderSold(int orderId) {
		List<Ticket> tickets = ticketDAO.getTicketsByOrder(orderId);
		for (Ticket ticket : tickets) {
			markTicketSold(ticket.getId());
		}
		orderDAO.setOrderingPayed(orderId);
	}

	public List<Order> getUnpaidValidOrders() {
		return orderDAO.getUnpaidValidOrderings();
	}

	public List<OrderAndPerson> getUnpaidValidOrdersWithNames() {
		List<Order> orders = orderDAO.getUnpaidValidOrderings();
		List<OrderAndPerson> orderAndPersons = new ArrayList<>();
		for (Order order : orders) {
			Person person = personDAO.getPerson(order.getBuyerId());
			orderAndPersons.add(new OrderAndPerson(order, person));
		}
		return orderAndPersons;
	}

}
