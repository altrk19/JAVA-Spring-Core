package _03.jsr330.dao;

import javax.inject.Named;

import org.springframework.stereotype.Repository;

import _03.jsr330.model.Person;

//@Repository
@Named
public class PersonDAOImpl implements PersonDAO {

	@Override
	public void insertPerson(Person person) {
		System.out.println("PersonDAOImpl #insertPerson");
	}

}
