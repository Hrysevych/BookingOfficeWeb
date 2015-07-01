package com.bookingOffice.www;


import java.util.TimeZone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookingOffice.www.services.AccountantService;
import com.bookingOffice.www.services.AdministratorService;
import com.bookingOffice.www.services.AnalystService;
import com.bookingOffice.www.services.CustomerService;
import com.bookingOffice.www.services.SecurityService;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/application-config.xml");

		AccountantService accountantService = (AccountantService) context
				.getBean("accountantServiceImpl");

		AdministratorService administratorService = (AdministratorService) context
				.getBean("administratorServiceImpl");

		AnalystService analystService = (AnalystService) context
				.getBean("analystServiceImpl");

		CustomerService customerService = (CustomerService) context
				.getBean("customerServiceImpl");

		SecurityService securityService = (SecurityService) context
				.getBean("securityServiceImpl");

		String password = "1";
		System.out.println(password.hashCode());

		System.out.println(TimeZone.getDefault().getID());
		
	}
}
