package _03.jpa.hibernate.dao;

import java.util.List;

import _01.jpa.model.Person;

public interface PersonHibernateDAO {

	public void insert(Person person);
	
	public Person getPersonById(int id);

	public List<Person> getAllPersons();

	public void update(Person person);

	public void delete(int id);
}
