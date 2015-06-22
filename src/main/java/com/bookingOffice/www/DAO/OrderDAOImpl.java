package com.bookingOffice.www.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookingOffice.www.util.SellsReport;
import com.bookingOffice.www.util.ValidityDurationUtil;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@PersistenceContext
	EntityManager em;

	public Order getOrdering(int id) {
		return em.find(Order.class, id);
	}

	@Transactional
	public void setOrderingPayed(int id) {
		Order ordering = em.find(Order.class, id);
		if (ordering != null) {
			ordering.setPayed(1);
		}
	}

	public List<Order> getUnpaidValidOrderings() {
		TypedQuery<Order> query = em.createQuery(
				"SELECT o FROM Ordering o WHERE o.payed = 0 and "
						+ "(o.validDate > CURRENT_DATE)", Order.class);
		return query.getResultList();
	}

	public List<Order> getAllOrderings() {
		TypedQuery<Order> query = em.createQuery("SELECT o FROM Ordering o",
				Order.class);
		return query.getResultList();
	}

	public List<Order> getInvalidOrderings() {
		TypedQuery<Order> query = em.createQuery(
				"SELECT o FROM Ordering o WHERE payed = 0 and "
						+ "o.validDate > CURRENT_DATE", Order.class);
		return query.getResultList();
	}

	@Transactional
	public void addOrdering(Order ordering) {
		if (ordering.getId() == 0) {
			em.persist(ordering);
		}
		else {
			em.merge(ordering);
		}
		

	}

	@Transactional
	public void deleteOrdering(int id) {
		Order ordering = em.find(Order.class, id);
		if (ordering != null) {
			em.remove(ordering);
		}

	}

	public List<Order> getOrderingsByDates(Date from, Date until) {
		TypedQuery<Order> query = em
				.createQuery(
						"SELECT o FROM Ordering o WHERE o.validDate BETWEEN (':from' and ':until')",
						Order.class);
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		return query.getResultList();
	}

	public SellsReport getTotalReport(Date from, Date until) {
		
		String sql = "SELECT new com.bookingOffice.www.util.SellsReport"
				+ " (max(o.validDate), count(f.ticketPrice), sum(f.ticketPrice))"
				+ "from Ordering o, Flight f, Ticket t "
				+ "WHERE (o.validDate between :from and :until) and t.orderId = o.id and t.flightId = f.id";
		TypedQuery<SellsReport> query = em.createQuery(sql, SellsReport.class);
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		return query.getSingleResult();
	}

	public List<SellsReport> getDailyReports(Date from, Date until) {
		String sql = "SELECT new com.bookingOffice.www.util.SellsReport"
				+ " (o.validDate, count(f.ticketPrice), sum(f.ticketPrice)) " 
				+ "from Ordering o, Flight f, Ticket t "
				+ "WHERE (o.validDate between :from and :until) "
				+ "and (t.orderId = o.id) and (t.flightId = f.id) "
				+ "group by o.validDate";
		TypedQuery<SellsReport> query = em.createQuery(sql, SellsReport.class);
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		return query.getResultList();
	}

}
