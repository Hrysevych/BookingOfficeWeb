package com.bookingOffice.www.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bookingOffice.www.util.SellsReport;
import com.bookingOffice.www.util.ValidityDurationUtil;

@Repository
public class OrderingDAOImpl implements OrderingDAO {
	@PersistenceContext
	EntityManager em;

	public Ordering getOrdering(int id) {
		return em.find(Ordering.class, id);
	}

	@Transactional
	public void setOrderingPayed(int id) {
		Ordering ordering = em.find(Ordering.class, id);
		if (ordering != null) {
			ordering.setPayed(1);
		}
	}

	public List<Ordering> getValidOrderings() {
		TypedQuery<Ordering> query = em.createQuery(
				"SELECT O FROM Ordering o WHERE payed = 0 and "
						+ "validDate <= CURRENT_DATE", Ordering.class);
		return query.getResultList();
	}

	public List<Ordering> getAllOrderings() {
		TypedQuery<Ordering> query = em.createQuery("SELECT O FROM Ordering o",
				Ordering.class);
		return query.getResultList();
	}

	public List<Ordering> getInvalidOrderings() {
		TypedQuery<Ordering> query = em.createQuery(
				"SELECT O FROM Ordering o WHERE payed = 0 and "
						+ "validDate > CURRENT_DATE", Ordering.class);
		return query.getResultList();
	}

	@Transactional
	public void addOrdering(Ordering ordering) {
		if (ordering.getId() == 0) {
			em.persist(ordering);
		}
		else {
			em.merge(ordering);
		}
		

	}

	@Transactional
	public void deleteOrdering(int id) {
		Ordering ordering = em.find(Ordering.class, id);
		if (ordering != null) {
			em.remove(ordering);
		}

	}

	public List<Ordering> getOrderingsByDates(Date from, Date until) {
		TypedQuery<Ordering> query = em
				.createQuery(
						"SELECT O FROM Ordering o WHERE validDate BETWEEN (':from' and ':until')",
						Ordering.class);
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		return query.getResultList();
	}

	public SellsReport getTotalReport(Date from, Date until) {
		String sql = "SELECT new com.bookingOffice.www.util.SellsReport"
				+ " (max(o.validDate), count(f.ticketPrice), sum(f.ticketPrice))"
				+ "from Ordering o, Flight f, Ticket t "
				+ "WHERE (o.validDate between :from and :until) and t.orderId = o.id and t.flightID = f.id";
		TypedQuery<SellsReport> query = em.createQuery(sql, SellsReport.class);
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		return query.getSingleResult();
	}

	public List<SellsReport> getDailyReports(Date from, Date until) {
		String sql = "SELECT new com.bookingOffice.www.util.SellsReport"
				+ " (o.validDate, count(f.ticketPrice), sum(f.ticketPrice)) " 
				+ "from Ordering o, Flight f, Ticket t "
				+ "WHERE (o.validDate between '2014-01-01' and '2016-12-31') "
				+ "and (t.orderId = o.id) and (t.flightID = f.id) "
				+ "group by o.validDate";
		TypedQuery<SellsReport> query = em.createQuery(sql, SellsReport.class);
		return query.getResultList();
	}

}
