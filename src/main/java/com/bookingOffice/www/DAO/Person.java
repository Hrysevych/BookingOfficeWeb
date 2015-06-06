package com.bookingOffice.www.DAO;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.bookingOffice.www.util.Roles;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int role;
	private int active;
	@Transient
	private ArrayList<Ticket> cart;

	public ArrayList<Ticket> getCart() {
		return cart;
	}

	public void addTicketToCart(Ticket ticket) {
		cart.add(ticket);
	}

	public void removeTicketFromCart(int index) {
		cart.remove(index);
	}

	public void fillTicketInfo(int index, String firstName, String lastName) {
		Ticket ticket = cart.get(index);
		ticket.setFirstName(firstName);
		ticket.setLastName(lastName);
		cart.set(index, ticket);
	}

	/**
	 * @return the nickname
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the role
	 */
	public Roles getRole() {
		return Roles.values()[role];
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(Roles role) {
		this.role = role.ordinal();
	}

	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	/**
	 * @param cart
	 *            the cart to set
	 */
	public void setCart(ArrayList<Ticket> cart) {
		this.cart = cart;
	}

	public String toString() {
		return "Person [First name=" + firstName + ", Last name=" + lastName
				+ ", role=" + role + "]";
	}

	public int getId() {
		return id;
	}
}
