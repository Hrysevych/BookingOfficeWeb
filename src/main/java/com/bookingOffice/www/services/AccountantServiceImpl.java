package com.bookingOffice.www.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.Ordering;
import com.bookingOffice.www.DAO.OrderingDAO;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.DAO.TicketDAO;

@Named
public class AccountantServiceImpl implements AccountantService {

	@Inject
	private FlightDAO flightDAO;
	@Inject
	private TicketDAO ticketDAO;
	@Inject
	private OrderingDAO orderingDAO;

	public void markTicketSold(int id) {
		Ticket ticket = ticketDAO.getTicket(id);
		Flight flight = flightDAO.getFlight(ticket.getFlightID());
		flight.setTicketsBooked(flight.getTicketsBooked() - 1);
		flight.setTicketsSold(flight.getTicketsSold() + 1);
	}

	public void markOrderingSold(int orderId) {
		List<Ticket> tickets = ticketDAO.getTicketsByOrder(orderId);
		for (Ticket ticket : tickets) {
			markTicketSold(ticket.getId());
		}
	}

	public List<Ordering> findOrderingsNotExpired() {
		return orderingDAO.getValidOrderings();
	}

}
