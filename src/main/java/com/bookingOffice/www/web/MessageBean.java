package com.bookingOffice.www.web;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("msgs")
@Scope("session")
public class MessageBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String departureRequired = "Departure field could not be empty";
	private final String fieldRequired = "Departure field could not be empty";
	private final String dateFormat = "Input date in format yyyy-mm-dd";

	public MessageBean() {
	}

	/**
	 * @return the departureRequired
	 */
	public String getDepartureRequired() {
		return departureRequired;
	}

	/**
	 * @return the fieldRequired
	 */
	public String getFieldRequired() {
		return fieldRequired;
	}

	/**
	 * @return the dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}

}
