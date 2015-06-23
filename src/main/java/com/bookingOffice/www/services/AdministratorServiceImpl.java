package com.bookingOffice.www.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.Order;
import com.bookingOffice.www.DAO.OrderDAO;
import com.bookingOffice.www.DAO.Ticket;
import com.bookingOffice.www.DAO.TicketDAO;
import com.bookingOffice.www.util.FlightError;

/**
 * @author deHrys
 *
 */
@Named
public class AdministratorServiceImpl implements AdministratorService {
	@Inject
	private FlightDAO flightDAO;
	@Inject
	private OrderDAO orderingDAO;
	@Inject
	private TicketDAO ticketDAO;

	public void addFlight(Flight flight) {
		flightDAO.addFlight(flight);
	}

	public void addTickets(int id, int quantity) {
		flightDAO.editTicketsNumber(id, quantity);
	}

	public void subtractTickets(int id, int quantity) {
		Flight flight = flightDAO.getFlight(id);
		if ((flight.getTicketsTotal() - quantity) > (flight.getTicketsSold() + flight
				.getTicketsBooked())) {
			flightDAO.editTicketsNumber(id, -quantity);
		} else {
			throw new FlightError("Number of total tickets can't be lower "
					+ "than sum of sold and booked tickets");
		}
	}

	public Flight getFlight(int id) {
		return flightDAO.getFlight(id);
	}

	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}

	public void releaseUnpaidTickets() {
		List<Order> orderings = orderingDAO.getInvalidOrderings();
		for (Order ordering : orderings) {
			int orderId = ordering.getId();
			List<Ticket> tickets = ticketDAO.getTicketsByOrder(orderId);
			for (Ticket ticket : tickets) {
				int flightId = ticket.getFlightId();
				Flight flight = flightDAO.getFlight(flightId);
				flight.setTicketsBooked(flight.getTicketsBooked() - 1);
				ticketDAO.deleteTicket(ticket.getId());
				flightDAO.addFlight(flight);
			}
			orderingDAO.deleteOrdering(orderId);
		}
	}

	public void deleteFlight(int id) {
		flightDAO.deleteFlight(id);
	}

	@Override
	public List<Order> getInvalidOrderings() {
		return orderingDAO.getInvalidOrderings();
	}
}
