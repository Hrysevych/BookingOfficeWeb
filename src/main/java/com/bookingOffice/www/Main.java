package com.bookingOffice.www;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookingOffice.www.services.AccountantService;
import com.bookingOffice.www.services.AdministratorService;
import com.bookingOffice.www.services.AnalyticService;
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

		AnalyticService analyticService = (AnalyticService) context
				.getBean("analyticServiceImpl");

		CustomerService customerService = (CustomerService) context
				.getBean("customerServiceImpl");

		SecurityService securityService = (SecurityService) context
				.getBean("securityServiceImpl");

	}
}
