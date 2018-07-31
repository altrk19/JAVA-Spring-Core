package _03.jpa.hibernate.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.jpa.model.Person;
import _03.jpa.hibernate.dao.PersonHibernateDAO;


public class SpringHibernateTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_03.hibernate.xml");

		PersonHibernateDAO dao = context.getBean(PersonHibernateDAO.class);

		Person person1 = new Person("Ali", "Bey", 1994);
		
		dao.insert(person1);
		
		Person foundPerson = dao.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		// update
		person1.setName("Gavin"); 		//hibernate'in babasý
		person1.setSurname("King");
		dao.update(person1);
		System.out.println("After Update...");

		// find
		foundPerson = dao.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		Person person2 = new Person("James", "Gosling", 1955);
		Person person3 = new Person("Rod", "Johnson", 1234);

		dao.insert(person2);
		dao.insert(person3);

		// delete
		dao.delete(1);

		// list
		List<Person> personList = dao.getAllPersons();
		System.out.println("Listing...");
		for (Person p : personList) {
			System.out.println(p);
		}
		
		context.close();

	}
}
//ek olarak aþaðýdaki dependency eklendi
/*
<groupId>javax.xml.bind</groupId>
<artifactId>jaxb-api</artifactId>
<version>2.3.0</version>
</dependency>
*/