package com.bookingOffice.www.services;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.FlightDAO;
import com.bookingOffice.www.DAO.OrderDAO;
import com.bookingOffice.www.DAO.TicketDAO;
import com.bookingOffice.www.util.SellsReport;

@Named
public class AnalystServiceImpl implements AnalystService {
	@Inject
	OrderDAO orderingDAO;
	@Inject
	FlightDAO flightDAO;
	@Inject
	TicketDAO ticketDAO;

	public SellsReport getTotalReport(Date from, Date until) {
		return orderingDAO.getTotalReport(from, until);
	}

	public List<SellsReport> getDailyReportsByDates(Date from, Date until) {
		return orderingDAO.getDailyReportsByDates(from, until);
	}

	public List<SellsReport> getDailyReportsByDestinations(Date from, Date until) {
		return orderingDAO.getDailyReportsByDestinations(from, until);
	}

}
