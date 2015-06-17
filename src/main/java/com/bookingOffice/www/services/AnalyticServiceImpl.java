package com.bookingOffice.www.services;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.Ordering;
import com.bookingOffice.www.DAO.OrderingDAO;
import com.bookingOffice.www.DAO.TicketDAO;
import com.bookingOffice.www.util.SellsReport;


@Named
public class AnalyticServiceImpl implements AnalyticService {
	@Inject
	OrderingDAO orderingDAO;
	@Inject
	FlightDAO flightDAO;
	@Inject
	TicketDAO ticketDAO;

	public SellsReport getTotalReport(Date from, Date until) {
		return orderingDAO.getTotalReport(from, until);
	}

	public List<SellsReport> getDailyReports(Date from, Date until) {
		return orderingDAO.getDailyReports(from, until);
	}

	public static class CompareByDate implements Comparator<Ordering> {

		public int compare(Ordering o1, Ordering o2) {
			if (o1.getValidDate().before(o2.getValidDate()))
				return -1;
			else
				return 1;
		}

	}
}
