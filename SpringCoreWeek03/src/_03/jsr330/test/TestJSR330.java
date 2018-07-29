package _03.jsr330.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.jsr330.model.Person;
import _03.jsr330.service.PersonService;
import _03.jsr330.service.PersonServiceImpl;




public class TestJSR330 {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("_03.jsr330.xml");
		
		PersonService personService=context.getBean("pServiceJSR330",PersonServiceImpl.class);
		
		Person person=new Person();     //Person sýnýfý baþka sýnýfa ait obje barýndýrmadýgýndan inject iþlemi yapýlmadý.
		person.setName("ali");
		person.setSurname("bey");
		personService.insertPerson(person);
	}

}
