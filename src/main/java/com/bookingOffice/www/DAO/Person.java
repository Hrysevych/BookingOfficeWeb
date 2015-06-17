package com.bookingOffice.www.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bookingOffice.www.util.Roles;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private int passwordHash;
	private String firstName;
	private String lastName;
	private int role;
	private int active;
	

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

	public String toString() {
		return "Person [First name=" + firstName + ", Last name=" + lastName
				+ ", role=" + role + "]";
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @return the passwordHash
	 */
	public int getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(int passwordHash) {
		this.passwordHash = passwordHash;
	}
}
