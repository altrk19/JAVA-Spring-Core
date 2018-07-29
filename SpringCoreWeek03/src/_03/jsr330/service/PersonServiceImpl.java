package _03.jsr330.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _03.jsr330.dao.PersonDAO;
import _03.jsr330.model.Person;


//@Service(value="pService")
@Named(value="pServiceJSR330")
@Singleton //Spring beanleri otomatik olarak singleton'dur.
public class PersonServiceImpl implements PersonService {
	
	//@Autowired
	@Inject
	//@Autowired yerine @Inject annotation'unu Springte kullanabiliriz.
	private PersonDAO personDAO;

	@Override
	public void insertPerson(Person person) {

		System.out.println("PersonServiceImpl #insertPerson");
		
		personDAO.insertPerson(person);
		
	}
	

}
