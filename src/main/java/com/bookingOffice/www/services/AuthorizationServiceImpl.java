package com.bookingOffice.www.services;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.DAO.PersonDAO;

@Named
public class AuthorizationServiceImpl implements AuthorizationService {
	@Inject
	PersonDAO personDAO;

	public Person getPerson(String email) {
		return personDAO.getPerson(email);
	}

	public Person getPerson(int id) {
		return personDAO.getPerson(id);
	}

	public boolean checkPassword(String email, int passwordHash) {
		return (getPerson(email).getPasswordHash() == passwordHash);
	}

}
