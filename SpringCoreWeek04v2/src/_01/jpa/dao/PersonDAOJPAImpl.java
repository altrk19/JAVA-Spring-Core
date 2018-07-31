package _01.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import _01.jpa.model.Person;


public class PersonDAOJPAImpl implements PersonDAOJPA{

	private EntityManager entityManager;
	private EntityManagerFactory factory;
	

	public PersonDAOJPAImpl(EntityManagerFactory factory) {
		super();
		this.factory = factory;
		entityManager = factory.createEntityManager();
	}


	@Override
	public void insert(Person person) {
		entityManager.getTransaction().begin();
		entityManager.persist(person);                                    //persist ekle demek degil , kaydet demek. update iþleminde de persist yapýlýyor.
		entityManager.getTransaction().commit();
	}


	@Override
	public Person getPersonById(int id) {
		return entityManager.find(Person.class, id);
	}


	@Override
	public List<Person> getAllPersons() {
		TypedQuery<Person> query = entityManager.createQuery("Select e from Person e", Person.class);
		return query.getResultList();
	}


	@Override
	public void update(Person person) {
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
		
	}


	@Override
	public void delete(int id) {
		Person person = getPersonById(id);
		if (person != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(person);
			entityManager.getTransaction().commit();
		}
		
	}

}
