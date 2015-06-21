package com.bookingOffice.www.DAO;

import java.util.List;

public interface PersonDAO {

	public void create(Person p);

	public void activate(int id);

	public void deactivate(int id);
	
	public void deletePerson(int id);

	public Person getPerson(int id);

	public List<Person> getPersonsList();
}
