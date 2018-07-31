package _01.jpa.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.jpa.dao.PersonDAOJPA;
import _01.jpa.model.Person;


public class SpringJPATest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_01.jpa.xml"); 	//entityManager bean'i olusturuluyor ve dao sýnýfýnda kullanýlmak üzere inject ediliyor.

		PersonDAOJPA dao = context.getBean(PersonDAOJPA.class);

		// create person object
		Person person1 = new Person("oldName", "oldSurname", 1994);	

		// insert
		dao.insert(person1);

		// find
		Person foundPerson = dao.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		// update
		person1.setName("Ali");
		person1.setSurname("Bey");
		dao.update(person1);
		System.out.println("After Update...");

		// find
		foundPerson = dao.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		Person person2 = new Person("James", "Gosling", 1955);
		Person person3 = new Person("Rod", "Johnson", 1234);                 //spring'in babasý

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
