package com.bookingOffice.www.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bookingOffice.www.util.CartTicket;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int orderId;
	private int flightId;
	private String firstName;
	private String lastName;
	private String passport;


	public Ticket(CartTicket cartContent) {
		this.flightId = cartContent.getFlightId();
		this.firstName = cartContent.getFirstName();
		this.lastName = cartContent.getLastName();
		this.passport = cartContent.getPassport();
	}

	public Ticket() {
	}

	/**
	 * @return the flightID
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * @param flightID
	 *            the flightID to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
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

	/**
	 * @return the orderNumber
	 */
	public int getOrderId() {
		return orderId;
	}

	/**
	 * @param orderNumber
	 *            the orderNumber to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

	public String toString() {
		return "Ticket [id=" + id + ", orderId=" + orderId + ", flightId="
				+ flightId + ", "
				+ (firstName != null ? "firstName=" + firstName + ", " : "")
				+ (lastName != null ? "lastName=" + lastName + ", " : "")
				+ (passport != null ? "passport=" + passport : "") + "]";
	}

}
