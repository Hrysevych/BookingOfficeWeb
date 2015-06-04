package com.bookingOffice.www;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
public class HelloBean {
	public String getMessage() {
		return "Hello, World!";
	}
}
