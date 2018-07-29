package _02.stereotype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _02.stereotype.dao.PersonDAO;
import _02.stereotype.model.Person;

@Service(value="pService")
//personServiceImpl'dir default ismi
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	//Autowired kullanýldýgýnda getter setter constructor'a gerek yoktur. Spring otomatik halleder
	private PersonDAO personDAO;
	
	@Override
	public void insertPerson(Person person) {
		
		System.out.println("PersonServiceImpl #insertPerson");
		
		personDAO.insertPerson(person);
	}

}
