package _01.jdbc.dao;

import java.sql.SQLException;
import java.util.List;

import _01.jdbc.model.Person;


public interface PersonJDBCDAO {

	public void insertPerson(Person person) throws SQLException;
	public Person getPersonById(int id);
	public List<Person> getAllPersons();
	public void update(Person person);
	public void delete(int id);
    public void deleteAllPersons();
}
