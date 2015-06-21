package com.bookingOffice.www.services;

import java.sql.Date;
import java.time.LocalDate;
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

	public List<SellsReport> getDailyReports(Date from, Date until) {
		return orderingDAO.getDailyReports(from, until);
	}

	public SellsReport getTotalReport(LocalDate from, LocalDate until) {
		return getTotalReport(Date.valueOf(from), Date.valueOf(until));
	}

	public List<SellsReport> getDailyReports(LocalDate from, LocalDate until) {
		return getDailyReports(Date.valueOf(from), Date.valueOf(until));
	}

}
