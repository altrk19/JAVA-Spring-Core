package _03.jpa.hibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _01.jpa.model.Person;


@Repository("personHibernateDAOImpl") //!!!!! @REPOSITORY!!!  default adýný yazdým.
public class PersonHibernateDAOImpl implements PersonHibernateDAO{
	
	// JPA da EntityManagerFactory -> 
	// Native Hibernate te sessionFactory;
	@Autowired
	//Autowired icin setter ya da constructor a gerek yoktur!
	private SessionFactory sessionFactory;	

	// JPA da EntityManager
	// Native Hibernate Session
	public Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void insert(Person person) {
		// JPA da EntityTransaction
		// native hiberante te Transaction
		
		Session session = getSession();
		Transaction transacion = session.beginTransaction();
		session.persist(person);
		transacion.commit();
		session.close();
	}

	@Override
	public Person getPersonById(int id) {
		Session session = getSession();
		Person person = session.get(Person.class, id);
		session.close();
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		Session session = getSession();
		TypedQuery<Person> query = session.createQuery("Select e from Person e",Person.class);
		return query.getResultList();
	}

	@Override
	public void update(Person person) {
		Session session = getSession();
		Transaction transacion = session.beginTransaction();
		session.update(person);
		transacion.commit();
		session.close();
		
	}

	@Override
	public void delete(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			Session session = getSession();
			Transaction transacion = session.beginTransaction();
			session.delete(person);
			transacion.commit();
			session.close();
		}
		
	}
}
