package com.RJ.crud.proj.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.RJ.crud.proj.entity.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		logger.info("Person saved, details of person=" + person);
	}

	@Override
	public void updatePerson(Person person) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(person);
		logger.info("Person updated, details of person=" + person);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> persons = session.createQuery("from Person").list();
		for (Person person : persons) {
			logger.info("Person list::" + person);
		}
		return persons;
	}

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded, details of person=" + person);
		return person;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person person = (Person) session.load(Person.class, new Integer(id));

		if (null != person) {
			session.delete(person);
		}
		logger.info("Person deleted!, details of person=" + person);

	}

}
