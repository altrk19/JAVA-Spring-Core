package _01.jdbc.programmatic.transaction.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import _01.jdbc.programmatic.transaction.model.Address;
import _01.jdbc.programmatic.transaction.model.Person;

public class PersonDAOImpl implements PersonDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;                      //autowired kullanýlmadý çünkü setter injection yapýldý.
	private PlatformTransactionManager transactionManager;

	private final static String INSERT_PERSON = "insert into person (id, name, surname,birthYear) values (:id , :name , :surname , :birthYear)";
	private final static String INSERT_ADDRESS = "insert into address(addressId,street,zipcode,city) values(:addressId, :street , :zipcode , :city)";
	private final static String SET_PERSON_ADDRESS = "update person set addressId=:addressId where id=:id";
	
	//setter injection
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	//transaction iþlmemini yapmak için kullanýlýyor. 
	private TransactionStatus getTransactionStatus() {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
		return status;
	}

	@Override
	public void insert(Person person) {
		//3 tane ayrý sorgu yazýldý. 1. person ekle 2. adress ekle 3. id'si verilen person'a address id ekle.
		TransactionStatus status = getTransactionStatus();                        //rollback olursa eski haline alýyor.kayýt eklenmediði haline dönüyor.
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", person.getId());
		params.put("name", person.getName());
		params.put("surname", person.getSurname());
		params.put("birthYear", person.getBirthYear());
		try {

			namedParameterJdbcTemplate.update(INSERT_PERSON, params);
			// logging
			System.out.println("Person is inserted... " + person);
			//
			
			insertAddress(person.getAddress());                                            //address eklendi
			updatePersonAddress(person.getId(), person.getAddress().getAddressId());		//persona address bilgisi eklendi.
			
			// commit
			transactionManager.commit(status);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("rollback...");
			transactionManager.rollback(status);
		}
	}

	@Override
	public void insertAddress(Address address) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("addressId", address.getAddressId());
		params.put("street", address.getStreet());
		params.put("zipcode", address.getZipcode());
		params.put("city", address.getCity());
		namedParameterJdbcTemplate.update(INSERT_ADDRESS, params);
		// logging
		System.out.println("Address is inserted... " + address);
	}

	@Override
	public void updatePersonAddress(int id, int addressId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("addressId", addressId);
		namedParameterJdbcTemplate.update(SET_PERSON_ADDRESS, params);
	}

}
