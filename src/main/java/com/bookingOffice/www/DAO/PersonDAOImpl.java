package com.bookingOffice.www.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonDAOImpl implements PersonDAO {
	@PersistenceContext
	EntityManager em;

	@Transactional
	public void create(Person person) {
		if (person.getId() == 0) {
			em.persist(person);
		} else {
			em.merge(person);
		}
	}

	@Transactional
	public void activate(int id) {
		Person person = em.find(Person.class, id);
		if (person != null) {
			person.setActive(1);
		}
	}

	@Transactional
	public void deactivate(int id) {
		Person person = em.find(Person.class, id);
		if (person != null) {
			person.setActive(0);
		}
	}

	public Person getPerson(int id) {
		return em.find(Person.class, id);
	}

	public Person getPerson(String email) {
		TypedQuery<Person> query = em.createQuery(
				"SELECT p FROM Person p WHERE LOWER(p.email) = LOWER(:email)", Person.class);
		query.setParameter("email", email);
		Person person;
		try {
			person = query.getSingleResult();
		} catch (Exception e) {
			person = new Person();
		}
		return person;
	}

	public List<Person> getPersonsList() {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p",
				Person.class);
		return query.getResultList();
	}

	@Transactional
	public void deletePerson(int id) {
		Person person = em.find(Person.class, id);
		if (person != null) {
			em.remove(person);
		}
	}

}
