package _02.stereotype.dao;

import org.springframework.stereotype.Repository;

import _02.stereotype.model.Person;
@Repository
//e�er bu s�n�f i�in herhangi bir stereotype kullanmazsak bu durumda Spring ilgili bean'i bulamaz.
//@Autowired varsay�lan olarak required true olarak �al���r. bu nedenle ilgili exception cal�sma zamn�nda f�rlat�l�r.
public class PersonDAOImpl implements PersonDAO {

	@Override
	public void insertPerson(Person person) {
		System.out.println("PersonDAOImpl #insertPerson");
	}

}
