package com.bookingOffice.www.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.Order;
import com.bookingOffice.www.DAO.OrderDAO;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.DAO.TicketDAO;

@Named
public class CustomerServiceImpl implements CustomerService {
	@Inject
	private FlightDAO flightDAO;
	@Inject
	private TicketDAO ticketDAO;
	@Inject
	private OrderDAO orderingDAO;

	public List<Flight> getFlightsFiltered(Flight flight) {
		return flightDAO.getFlightsFiltered(flight);
	}

	public void submitCart(List<Ticket> tickets, int personId) {
		Order ordering = new Order();
		ordering.setBuyerId(personId);
		ordering.setPayed(0);
		ordering.setValidDate(Date.valueOf(LocalDate.now().plusDays(3)));
		orderingDAO.addOrdering(ordering);
		System.out.println(ordering.getId());
		for (Ticket ticket : tickets) {
			ticket.setOrderId(ordering.getId());
			ticketDAO.addTicket(ticket);
		}
	}

	public Flight getFlight(int id) {
		return flightDAO.getFlight(id);
	}

}
