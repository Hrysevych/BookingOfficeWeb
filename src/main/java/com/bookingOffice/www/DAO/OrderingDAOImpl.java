package com.bookingOffice.www.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		em.persist(ordering);

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
		Query query = em
				.createQuery(
						"select sum(f.ticketprice), count(*) from ORDERING o,"
								+ " FLIGHT f, TICKET t where (o.VALIDDATE between ':from' and ':until') "
								+ "and t.ORDERID = o.id and t.FLIGHTID = f.ID");
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		System.out.println("!!! " + query);
		/*TypedQuery<Double> query = em
				.createQuery(
						"select sum(f.ticketprice), count(*) from ORDERING o,"
								+ " FLIGHT f, TICKET t where (o.VALIDDATE between ':from' and ':until') "
								+ "and t.ORDERID = o.id and t.FLIGHTID = f.ID",
						Double.class);*/
		
		double total = (Double) query.getResultList().get(0);
		int quantity = (Integer) query.getResultList().get(1);
		SellsReport report = new SellsReport(quantity, total);
		return report;
	}

	public List<SellsReport> getDailyReports(Date from, Date until) {
		TypedQuery<SellsReport> query = em
				.createQuery(
						"select o.VALIDDATE, sum(f.ticketprice), count(*) from ORDERING o, FLIGHT f, TICKET t"
								+ "where (o.VALIDDATE between ':from' and ':until') and (t.ORDERID = o.id)"
								+ "and (t.FLIGHTID = f.ID) group by o.VALIDDATE ",
						SellsReport.class);
		query.setParameter("from", ValidityDurationUtil.toValidDate(from));
		query.setParameter("until", ValidityDurationUtil.toValidDate(until));
		return query.getResultList();
	}

}
