package com.bookingOffice.www.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TicketDAOImpl implements TicketDAO {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public void addTicket(Ticket ticket) {
		em.persist(ticket);

	}

	@Transactional
	public void markTicketSold(int id) {
		Ticket ticket = em.find(Ticket.class, id);
		if (ticket != null) {
			ticket.setPayed(1);
		}

	}

	public List<Ticket> getTicketsByPerson(Person person) {
		TypedQuery<Ticket> query = em.createQuery(
				"SELECT t FROM Ticket t WHERE buyerID = :buyer", Ticket.class);
		query.setParameter("buyer", person.getId());
		return query.getResultList();
	}

	public List<Ticket> getTicketsByOrder(int orderId) {
		TypedQuery<Ticket> query = em.createQuery(
				"SELECT t FROM Ticket t WHERE orderId = :order",
				Ticket.class);
		query.setParameter("order", orderId);
		return query.getResultList();
	}

	public Ticket getTicket(int id) {
		return em.find(Ticket.class, id);

	}

}
