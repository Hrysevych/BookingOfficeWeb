package com.bookingOffice.www.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.services.SecurityService;

@Named
@Scope("session")
public class SecurityBean {
	@Inject
	SecurityService securityService;
	private List<Person> persons = null;
	private Person person = null;
	private int role;

	public SecurityBean() {
		super();
	}

	public void refreshPersons() {
		persons = securityService.getPersonsList();
	}

	public String editPerson(String stringId) {
		int id = Integer.parseInt(stringId);
		if (id != 0) {
			person = securityService.getPerson(id);
		} else {
			person = new Person();
		}
		return "newPerson";
	}

	public String addPerson() {
		person.setRole(role);
		person.setPasswordHash(1216985755);
		securityService.addPerson(person);
		return "Security";
	}

	public String deletePerson() {
		securityService.deletePerson(person.getId());
		return "Security";
	}

	public String changePersonActiveState(String stringId) {
		int id = Integer.parseInt(stringId);
		person = securityService.getPerson(id);
		if (person.getActive() == 1) {
			securityService.deactivatePerson(id);
		} else {
			securityService.activatePerson(id);
		}
		return "Security";
	}

	/**
	 * @return the persons
	 */
	public List<Person> getPersons() {
		return persons;
	}

	/**
	 * @param persons
	 *            the persons to set
	 */
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

}
