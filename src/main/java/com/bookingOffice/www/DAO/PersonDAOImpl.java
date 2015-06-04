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
	public void create(Person p) {
		em.persist(p);
	}

	@Transactional
	public void activate(int id) {
		Person p = em.find(Person.class, id);
		if (p != null) {
			p.setActive(1);
		}
	}

	@Transactional
	public void deactivate(int id) {
		Person p = em.find(Person.class, id);
		if (p != null) {
			p.setActive(0);
		}
	}

	public Person getPerson(int id) {
		return em.find(Person.class, id);
	}

	public List<Person> getPersonsList() {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p",
				Person.class);
		return query.getResultList();
	}

}
