package com.bookingOffice.www.services;

import com.bookingOffice.www.DAO.Person;

public interface AuthorizationService {
	
	public Person getPerson(String email);
	
	public Person getPerson(int id);
	
	public boolean checkPassword(String email, int passwordHash);

}
