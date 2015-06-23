package com.bookingOffice.www.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class flightClient {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("client-beans.xml");
		FlightWS service = context.getBean(FlightWS.class);
		String result = service.getFlightList();
		System.out.println(result);
	}
}
