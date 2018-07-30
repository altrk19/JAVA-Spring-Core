package _01.jdbc.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.jdbc.dao.PersonJDBCDAO;
import _01.jdbc.dao.PersonJDBCDAOImpl;
import _01.jdbc.model.Person;


public class SpringJDBCTest {

	public static void main(String[] args) throws Exception {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_01.spring.jdbc.xml");
		
		PersonJDBCDAO dao = context.getBean(PersonJDBCDAOImpl.class);
		
		Person person1 = new Person(1, "ali", "bey", 1994);
		
		// deleteAllPersons
		dao.deleteAllPersons();
		
		// insert
		dao.insertPerson(person1);

		// find
		dao.getPersonById(1);

		// update
		person1.setName("Aliii");
		dao.update(person1);

		// delete 
		dao.delete(1);

		Person person2 = new Person(2, "umut", "can", 2000);
		Person person3 = new Person(3, "ata", "kan", 2013);

		dao.insertPerson(person2);
		dao.insertPerson(person3);

		// getAllPersons
		dao.getAllPersons();

		// deleteAllPersons
		dao.deleteAllPersons();
		
		context.close();
	}
}
