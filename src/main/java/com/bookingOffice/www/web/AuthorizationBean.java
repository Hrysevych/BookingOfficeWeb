package com.bookingOffice.www.web;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.services.AuthorizationService;

@Named
@Scope("session")
public class AuthorizationBean {
	@Inject
	AuthorizationService authorizationService;

	private Person person;
	private String email;
	private String password;
	private String userHeader = "";

	public String logIn() {
		Person logInPerson = authorizationService.getPerson(email);
		RequestContext requestContext = RequestContext.getCurrentInstance();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String outcome = facesContext.getViewRoot().getViewId();
		outcome = outcome.substring(1, outcome.indexOf('.'));
		if ((logInPerson.getId() == 0)
				|| (logInPerson.getPasswordHash() != password.hashCode())
				|| (logInPerson.getActive() != 1)) {
			requestContext.execute("PF('wrongLogInMessage').show()");
			return outcome;
		}
		person = logInPerson;
		userHeader = "Welcome, " + person.getFirstName() + " "
				+ person.getLastName() + "!";
		outcome = person.getRole().toString();
		outcome = outcome.substring(0, 1) + outcome.substring(1).toLowerCase();
		if (outcome.equals("Customer")) outcome = "index";
		return outcome;
	}

	public String logOut() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		person = null;
		email = "";
		password = "";
		userHeader = "";
		requestContext.execute("PF('logOutDialog').hide()");
		return "index";
	}

	public AuthorizationBean() {
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
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
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userHeader
	 */
	public String getUserHeader() {
		return userHeader;
	}

	/**
	 * @param userHeader
	 *            the userHeader to set
	 */
	public void setUserHeader(String userHeader) {
		this.userHeader = userHeader;
	}

}
