package _01.jdbc.programmatic.transaction.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.jdbc.programmatic.transaction.dao.PersonDAO;
import _01.jdbc.programmatic.transaction.dao.PersonDAOImpl;
import _01.jdbc.programmatic.transaction.model.Address;
import _01.jdbc.programmatic.transaction.model.Person;



public class JdbcProgrammaticTransactionTest {
	public static void main(String[] args) throws SQLException {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("_01.jdbc.programmatic.transaction.xml");

		PersonDAO personDAO = ctx.getBean(PersonDAOImpl.class);

		// create Person object
		Person person = new Person(1, "Ali", "Bey", 1994);

		// create Address object
		Address address = new Address(100, "Java Street", "34000", "Istanbul");

		// setAddress
		person.setAddress(address);

		// insert
		personDAO.insert(person);

		Person person2 = new Person(2, "Umut", "Can", 2000);
		//zip code 5 haneli oldugu i�in sql kayd� kabul etmeyecek ve transaction rollback i�lemi olacak.
		//address eklenmedi�i i�in person da eklenmeyecektir. Rollback i�lemini �yle ayarlad�k.
		Address address2 = new Address(101, "new street", "throw exception!", "my city");        
		person2.setAddress(address2);

		personDAO.insert(person2);

		ctx.close();

	}
}