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
	private OrderingDAO orderingDAO;
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

	public void updateFlight(int id, Flight flight) {
		flightDAO.updateFlight(id, flight);
	}

	public List<Flight> getFlights() {
		return flightDAO.getFlights();
	}

	public void releaseUnpaidTickets() {
		List<Ordering> orderings = orderingDAO.getInvalidOrderings();
		for (Ordering ordering : orderings) {
			int orderingId = ordering.getId();
			List<Ticket> tickets = ticketDAO.getTicketsByOrder(orderingId);
			for (Ticket ticket : tickets) {
				int flightId = ticket.getFlightID();
				Flight flight = flightDAO.getFlight(flightId);
				flight.setTicketsBooked(flight.getTicketsBooked() - 1);
				flightDAO.updateFlight(flightId, flight);
			}
			orderingDAO.deleteOrdering(orderingId);
		}
	}
}
