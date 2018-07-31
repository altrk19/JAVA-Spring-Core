package _02.jpa.detailed.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.jpa.model.Person;
import _02.jpa.detailed.dao.PersonDAOJPADetailed;

public class SpringJPADetailedTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_02.jpa.detailed.xml");

		PersonDAOJPADetailed dao = context.getBean(PersonDAOJPADetailed.class);

		// create person object
		Person person1 = new Person("oldName", "oldSurname", 1989);

		// insert
		dao.insert(person1);

		// find
		Person foundPerson = dao.getPersonById(1);
		System.out.println("Found ... " + foundPerson);

		// update
		person1.setName("Umut");
		person1.setSurname("Can");
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
