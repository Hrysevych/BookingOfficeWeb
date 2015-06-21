package com.bookingOffice.www.util;

import java.sql.Date;

import com.bookingOffice.www.DAO.Order;
import com.bookingOffice.www.DAO.Person;

public class OrderAndPerson {
	private int id;
	private Date validDate;
	private String firstName;
	private String lastName;

	public OrderAndPerson() {

	}

	public OrderAndPerson(Order order, Person person) {
		this();
		this.id = order.getId();
		this.validDate = order.getValidDate();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
	}

	/**
	 * @return the id
	 */
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
	 * @return the validDate
	 */
	public Date getValidDate() {
		return validDate;
	}

	/**
	 * @param validDate
	 *            the validDate to set
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
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

}
