package _03.named.parameter.jdbc.template.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.named.parameter.jdbc.template.dao.PersonDAONamedJDBCTemplate;
import _03.named.parameter.jdbc.template.model.Person;


public class SpringNamedJDBCTemplateTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_03.spring.namedjdbctemplate.xml");

		PersonDAONamedJDBCTemplate dao = context.getBean(PersonDAONamedJDBCTemplate.class);

		Person person1 = new Person(101, "ali", "bey", 1994);
		Person person2 = new Person(1010, "umut ", "can", 2000);
		
		dao.deleteAllPersons();
		
		dao.insertPerson(person1);
		dao.insertPerson(person2);

		Person personFound = dao.getPersonById(101);
		System.out.println(personFound);

		person1.setName("Alixx");
		dao.update(person1);
		
		dao.getAllPersons();
		// delete
		dao.delete(101);
		
		dao.getAllPersons();
		
		dao.deleteAllPersons();
		
		context.close();
	}
}
