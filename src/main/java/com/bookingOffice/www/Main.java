package com.bookingOffice.www;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookingOffice.www.DAO.Flight;
import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.services.AdministratorService;
import com.bookingOffice.www.services.AnalyticService;
import com.bookingOffice.www.services.CustomerService;
import com.bookingOffice.www.services.SecurityService;
import com.bookingOffice.www.util.SellsReport;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/application-config.xml");

		AnalyticService analyticService = (AnalyticService) context
				.getBean("analyticServiceImpl");

		AdministratorService administratorService = (AdministratorService) context
				.getBean("administratorServiceImpl");

		CustomerService customerService = (CustomerService) context
				.getBean("customerServiceImpl");

		SecurityService securityService = (SecurityService) context
				.getBean("securityServiceImpl");

		// Person person = new Person();

		/*
		 * Flight flight = new Flight("KBP",
		 * Timestamp.valueOf("2015-05-28 06:00:00"), "JFK",
		 * Timestamp.valueOf("2015-05-28 12:00:00"), 15.2);
		 * administratorService.addFlight(flight);
		 * 
		 * SellsReport report = analyticService.getTotalReport(
		 * Date.valueOf("2014-01-01"), Date.valueOf("2016-01-01"));
		 * System.out.println(report);
		 */

		SellsReport report = analyticService.getTotalReport(
				Date.valueOf("2014-01-01"), Date.valueOf("2016-01-01"));
		System.out.println(report);
		/*
		 * List<Flight> flights = administratorService.getFlights(); for (Flight
		 * flight2 : flights) { System.out.println(flight2); }
		 */

	}
}
