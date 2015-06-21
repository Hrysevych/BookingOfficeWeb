package com.bookingOffice.www.DAO;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FlightDAOImpl implements FlightDAO {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public void addFlight(Flight flight) {
		if (flight.getId() == 0) {
			em.persist(flight);
		} else {
			em.merge(flight);
		}

	}

	@Transactional
	public void deleteFlight(int id) {
		Flight flight = em.find(Flight.class, id);
		if (flight != null) {
			flight.setDeleted(1);
		}

	}

	@Transactional
	public void editTicketsNumber(int id, int quantity) {
		Flight flight = em.find(Flight.class, id);
		if (flight != null) {
			flight.setTicketsTotal(flight.getTicketsTotal() + quantity);
		}

	}

	public List<Flight> getFlightsFiltered(Flight flight) {
		TypedQuery<Flight> query = em
				.createQuery(
						"SELECT f FROM Flight f WHERE f.departure = :departure and "
								+ "f.arrival = :arrival and "
								+ "f.arrivalTime >= :arrivalTime and f.ticketsTotal > "
								+ "(f.ticketsBooked + f.ticketsSold) and f.deleted = 0",
						Flight.class);
		query.setParameter("departure", flight.getDeparture());
		query.setParameter("arrival", flight.getArrival());
		if (flight.getArrivalTime() != null) {
			query.setParameter("arrivalTime", flight.getArrivalTime());
		} else {
			query.setParameter("arrivalTime", Timestamp.from(Instant.now()));
		}
		return query.getResultList();
	}

	public Flight getFlight(int id) {
		return em.find(Flight.class, id);
	}

	public List<Flight> getFlights() {
		TypedQuery<Flight> query = em.createQuery("SELECT f FROM Flight f where f.deleted != 1",
				Flight.class);
		return query.getResultList();
	}

}
