package com.bookingOffice.www.services;

import java.util.List;

import com.bookingOffice.www.DAO.Person;

public interface SecurityService {

	public void addPerson(Person person);

	public void activatePerson(int id);

	public void deactivatePerson(int id);

	public List<Person> getPersonsList();

}
