package com.bookingOffice.www.util;

import java.sql.Timestamp;

import com.bookingOffice.www.DAO.Flight;

public class CartTickets {
	private int flightId;
	private String departure;
	private Timestamp departureTime;
	private String arrival;
	private Timestamp arrivalTime;
	private double ticketPrice;
	private String firstName;
	private String lastName;
	private String passport;

	/**
	 * 
	 */
	public CartTickets() {
	}

	public CartTickets(Flight flight) {
		flightId = flight.getId();
		departure = flight.getDeparture();
		departureTime = flight.getDepartureTime();
		arrival = flight.getArrival();
		arrivalTime = flight.getArrivalTime();
		ticketPrice = flight.getTicketPrice();
	}

	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}

	/**
	 * @param departure
	 *            the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	/**
	 * @return the departureTime
	 */
	public Timestamp getDepartureTime() {
		return departureTime;
	}

	/**
	 * @param departureTime
	 *            the departureTime to set
	 */
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}

	/**
	 * @param arrival
	 *            the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	/**
	 * @return the arrivalTime
	 */
	public Timestamp getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * @param arrivalTime
	 *            the arrivalTime to set
	 */
	public void setArrivalTime(Timestamp arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * @return the ticketPrice
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * @param ticketPrice
	 *            the ticketPrice to set
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "CartContent ["
				+ (departure != null ? "departure=" + departure + ", " : "")
				+ (departureTime != null ? "departureTime=" + departureTime
						+ ", " : "")
				+ (arrival != null ? "arrival=" + arrival + ", " : "")
				+ (arrivalTime != null ? "arrivalTime=" + arrivalTime + ", "
						: "") + "ticketPrice=" + ticketPrice + ", "
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName : "") + "]";
	}

	/**
	 * @return the passport
	 */
	public String getPassport() {
		return passport;
	}

	/**
	 * @param passport
	 *            the passport to set
	 */
	public void setPassport(String passport) {
		this.passport = passport;
	}

	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId
	 *            the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

}
