package com.bookingOffice.www.web;

import javax.jws.WebService;

import com.bookingOffice.www.DAO.Flight;

@WebService
public interface FlightWS {
	
	String getFlightList();
	
	Flight getFlight(int id);

}
