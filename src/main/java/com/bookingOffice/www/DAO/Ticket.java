package com.bookingOffice.www.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int flightID;
	private String firstName;
	private String lastName;
	private int buyerId;
	private int orderId;
	private int payed;
	

	/**
	 * @return the flightID
	 */
	public int getFlightID() {
		return flightID;
	}

	/**
	 * @param flightID
	 *            the flightID to set
	 */
	public void setFlightID(int flightID) {
		this.flightID = flightID;
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
	 * @return the payed
	 */
	public int getPayed() {
		return payed;
	}

	/**
	 * @param payed
	 *            the payed to set
	 */
	public void setPayed(int payed) {
		this.payed = payed;
	}

	/**
	 * @return the buyerId
	 */
	public int getBuyerId() {
		return buyerId;
	}

	/**
	 * @param buyerId
	 *            the buyerId to set
	 */
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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

	public String toString() {
		return "Ticket [flightID=" + flightID + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", buyerId=" + buyerId
				+ ", payed=" + payed + "]";
	}

}
