package _03.named.parameter.jdbc.template.dao;

import java.util.List;

import _03.named.parameter.jdbc.template.model.Person;


public interface PersonDAONamedJDBCTemplate {

	public void insertPerson(Person person) throws Exception;
	
	public Person getPersonById(int id);
	
	public List<Person> getAllPersons();
	
	public void update(Person person);

	public void delete(int id);
	
	public void deleteAllPersons();
}
