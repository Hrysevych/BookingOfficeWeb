package com.bookingOffice.www.DAO;

import java.util.List;

public interface PersonDAO {

	public void create(Person p);

	public void activate(int id);

	public void deactivate(int id);
	
	public void deletePerson(int id);

	public Person getPerson(int id);
	
	public Person getPerson(String email);

	public List<Person> getPersonsList();

	public int getLastOrderId(int buyerId);
}
