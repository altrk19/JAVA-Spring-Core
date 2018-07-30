package _01.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import _01.jdbc.model.Person;


public class PersonJDBCDAOImpl implements PersonJDBCDAO{

	private final static String INSERT_PERSON = "insert into person (id, name, surname,birthYear) values (?, ?, ?,?)";
	private final static String SELECT_BYID = "select * from person where id=?";
	private final static String ALL_SELECT = "select * from person";
	private final static String UPDATE_PERSON = "update person set name=? , surname=? , birthYear=? where id=?";
	private final static String DELETE_PERSON = "delete from person where id=?";
	private final static String DELETE_PERSON_ALL = "delete from person";

	private DataSource dataSource;                          //datasource baðlantýlarý yönetir.

	public PersonJDBCDAOImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public void insertPerson(Person person) throws SQLException {

		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON);
			preparedStatement.setInt(1, person.getId());
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getSurname());
			preparedStatement.setInt(4, person.getBirthYear());			//parametreler verildi.
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// log basýldý.
			System.out.println("Person is inserted..." + person);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Person getPersonById(int id) {
		Person person = null;
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BYID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int birthYear = resultSet.getInt("birthYear");
				person = new Person(id, name, surname, birthYear);

				// logging
				System.out.println("Person is found..." + person);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> personList = new ArrayList<Person>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(ALL_SELECT);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				int birthYear = resultSet.getInt("birthYear");
				Person person = new Person(id, name, surname, birthYear);
				personList.add(person);
			}
			// logging
			System.out.println("Person list...");
			for (Person person : personList) {
				System.out.println(person);
			}
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return personList;
	}

	@Override
	public void update(Person person) {
		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON);
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getSurname());
			preparedStatement.setInt(3, person.getBirthYear());
			preparedStatement.setInt(4, person.getId());
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("Person is updated..." + person);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("Person is deleted... Id : " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteAllPersons() {
		try {

			Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_ALL);
			preparedStatement.executeUpdate();
			preparedStatement.close();

			// logging
			System.out.println("All Persons are deleted...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
