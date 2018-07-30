package _02.jdbc.template.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.jdbc.template.dao.PersonJDBCTemplateDAO;
import _02.jdbc.template.dao.PersonJDBCTemplateImplDAO;
import _02.jdbc.template.model.Person;


public class SpringJDBCTemplateTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_02.spring.jdbctemplate.xml");

		PersonJDBCTemplateDAO dao = context.getBean(PersonJDBCTemplateImplDAO.class);

		Person person = new Person(2, "ali", "bey", 1994);

		dao.insertPerson(person);
		
		// find
		//dao.getPersonById(1);

		// update
		person.setName("AliCan");
		dao.update(person);

		// delete
		dao.delete(2);

		Person person2 = new Person(12, "umut", "can", 1955);
		Person person3 = new Person(13, "ibra", "turk", 1961);

		dao.insertPerson(person2);
		dao.insertPerson(person3);

		// getAllPersons
		//dao.getAllPersons();
		
		dao.deleteAllPersons();
		context.close();
	}
}
