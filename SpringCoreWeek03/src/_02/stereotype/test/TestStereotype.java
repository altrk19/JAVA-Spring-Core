package _02.stereotype.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.stereotype.model.Person;
import _02.stereotype.service.PersonService;
import _02.stereotype.service.PersonServiceImpl;



public class TestStereotype {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("_02.stereotype.xml");
		
		PersonService personService=context.getBean("pService",PersonServiceImpl.class);
		
		Person person=new Person();     //Person sýnýfý baþka sýnýfa ait obje barýndýrmadýgýndan inject iþlemi yapýlmadý.
		person.setName("ali");
		person.setSurname("bey");
		personService.insertPerson(person);
	
	}

}
