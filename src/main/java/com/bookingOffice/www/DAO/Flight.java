package com.bookingOffice.www.DAO;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String departure;
	private Timestamp departureTime;
	private String arrival;
	private Timestamp arrivalTime;
	private double ticketPrice;
	private int ticketsTotal;
	private int ticketsBooked;
	private int ticketsSold;
	private int deleted;

	/**
	 * @param id
	 * @param departure
	 * @param departureTime
	 * @param arrival
	 * @param arrivalTime
	 * @param ticketsTotal
	 * @param ticketsBooked
	 * @param ticketsSold
	 * @param deleted
	 */
	public Flight(String departure, Timestamp departureTime, String arrival,
			Timestamp arrivalTime, double ticketPrice, int ticketsTotal,
			int ticketsBooked, int ticketsSold, int deleted) {
		this.departure = departure;
		this.departureTime = departureTime;
		this.arrival = arrival;
		this.arrivalTime = arrivalTime;
		this.ticketPrice = ticketPrice;
		this.ticketsTotal = ticketsTotal;
		this.ticketsBooked = ticketsBooked;
		this.ticketsSold = ticketsSold;
		this.deleted = deleted;
	}

	/**
	 * @param departure
	 * @param departureTime
	 * @param arrival
	 * @param arrivalTime
	 */
	public Flight(String departure, Timestamp departureTime, String arrival,
			Timestamp arrivalTime, double ticketPrice) {
		this(departure, departureTime, arrival, arrivalTime, ticketPrice, 0, 0,
				0, 0);
	}

	/**
	 * 
	 */
	public Flight() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
	
	public void setArrivalTime(java.util.Date arrivalTime) {
		this.arrivalTime = Timestamp.from(arrivalTime.toInstant());
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
	 * @return the ticketsTotal
	 */
	public int getTicketsTotal() {
		return ticketsTotal;
	}

	/**
	 * @param ticketsTotal
	 *            the ticketsTotal to set
	 */
	public void setTicketsTotal(int ticketsTotal) {
		this.ticketsTotal = ticketsTotal;
	}

	/**
	 * @return the ticketsBooked
	 */
	public int getTicketsBooked() {
		return ticketsBooked;
	}

	/**
	 * @param ticketsBooked
	 *            the ticketsBooked to set
	 */
	public void setTicketsBooked(int ticketsBooked) {
		this.ticketsBooked = ticketsBooked;
	}

	/**
	 * @return the ticketsSold
	 */
	public int getTicketsSold() {
		return ticketsSold;
	}

	/**
	 * @param ticketsSold
	 *            the ticketsSold to set
	 */
	public void setTicketsSold(int ticketsSold) {
		this.ticketsSold = ticketsSold;
	}

	/**
	 * @return the deleted
	 */
	public int getDeleted() {
		return deleted;
	}

	/**
	 * @param deleted
	 *            the deleted to set
	 */
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getTicketsAvailable() {
		return ticketsTotal - (ticketsBooked + ticketsSold);
	}

	public String toString() {
		return "Flight [departure=" + departure + ", departureTime="
				+ departureTime + ", arrival=" + arrival + ", arrivalTime="
				+ arrivalTime + ", ticketPrice=" + ticketPrice
				+ ", ticketsTotal=" + ticketsTotal + ", ticketsBooked="
				+ ticketsBooked + ", ticketsSold=" + ticketsSold + ", deleted="
				+ deleted + "]";
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
