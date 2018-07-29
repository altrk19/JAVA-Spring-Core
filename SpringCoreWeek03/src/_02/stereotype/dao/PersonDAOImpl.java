package _02.stereotype.dao;

import org.springframework.stereotype.Repository;

import _02.stereotype.model.Person;
@Repository
//eðer bu sýnýf için herhangi bir stereotype kullanmazsak bu durumda Spring ilgili bean'i bulamaz.
//@Autowired varsayýlan olarak required true olarak çalýþýr. bu nedenle ilgili exception calýsma zamnýnda fýrlatýlýr.
public class PersonDAOImpl implements PersonDAO {

	@Override
	public void insertPerson(Person person) {
		System.out.println("PersonDAOImpl #insertPerson");
	}

}
