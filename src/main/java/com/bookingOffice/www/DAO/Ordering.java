package com.bookingOffice.www.DAO;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordering {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	int buyerId;
	private int payed;
	private Date validDate;

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
	 * @return the validDate
	 */
	public Date getValidDate() {
		return validDate;
	}

	/**
	 * @param validDate
	 *            the orderDate to set
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
