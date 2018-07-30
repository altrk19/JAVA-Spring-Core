package _02.jdbc.template.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import _02.jdbc.template.model.Person;



public class PersonJDBCTemplateImplDAO implements PersonJDBCTemplateDAO {

	private final static String INSERT_PERSON = "insert into person (id, name, surname,birthYear) values (?, ?, ?,?)";
	private final static String SELECT_BYID = "select * from person where id=?";
	private final static String ALL_SELECT = "select * from person";
	private final static String UPDATE_PERSON = "update person set name=? , surname=? , birthYear=? where id=?";
	private final static String DELETE_PERSON = "delete from person where id=?";
	private final static String DELETE_PERSON_ALL = "delete from person";
	
	private JdbcTemplate jdbcTemplate;                      		//JdbcTemplate, Spring'e ait bir sýnýf.
	
	//burada constructor injection yapýldý. setter injection da yapabiliriz.
	public PersonJDBCTemplateImplDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	//setter injection
	//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	//	System.out.println("setter injection... JdbcTemplate");
	//	this.jdbcTemplate = jdbcTemplate;
	//}

	
	//PreparedStatement kullanýlmaz. Template kullanýlýr.
	//Normal JDBC Spring örnegine göre daha basit ve pratiktir
	@Override
	public void insertPerson(Person person) throws Exception {
		Object[] insertParams = new Object[] { person.getId(), person.getName(), person.getSurname(),person.getBirthYear() };	//parametre sayisi sirasi onemli!
		
		jdbcTemplate.update(INSERT_PERSON, insertParams);
		// logging
		System.out.println("Person is inserted... " + person);

	}
	@Override
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
				return null;
	}
	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Person person) {
		
		//burada parametreleri verdi. sonra aþaðýda sorguyu çalýþtýrdýk.
		Object[] insertParams = new Object[] { person.getName(), person.getSurname(), person.getBirthYear(),person.getId() };      
		jdbcTemplate.update(UPDATE_PERSON, insertParams);
		// logging
		System.out.println("Person is updated... " + person);
		
	}
	@Override
	public void delete(int id) {
		jdbcTemplate.update(DELETE_PERSON, id);
		// logging
		System.out.println("Person is deleted... Id :" + id);
		
	}
	@Override
	public void deleteAllPersons() {
		jdbcTemplate.update(DELETE_PERSON_ALL);
		
		System.out.println("All persons are deleted. ");
		
	}

}
