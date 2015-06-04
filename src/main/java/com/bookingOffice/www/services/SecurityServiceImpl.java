package com.bookingOffice.www.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.bookingOffice.www.DAO.Person;
import com.bookingOffice.www.DAO.PersonDAO;
import com.bookingOffice.www.util.PersonError;
import com.bookingOffice.www.util.Roles;

@Named
public class SecurityServiceImpl implements SecurityService {
	@Inject
	PersonDAO personDAO;

	public void addPerson(Person person) {
		if (!person.getRole().equals(Roles.SECURITY)) {
			personDAO.create(person);
		} else {
			throw new PersonError("Can't create new security officer");
		}
	}

	public void activatePerson(int id) {
		Person person = personDAO.getPerson(id);
		if (person != null) {
			personDAO.activate(id);
		}
	}

	public void deactivatePerson(int id) {
		Person person = personDAO.getPerson(id);
		if ((person != null) && (!person.getRole().equals(Roles.SECURITY))) {
			personDAO.deactivate(id);
		}

	}

	public List<Person> getPersonsList() {
		return personDAO.getPersonsList();
	}

}
