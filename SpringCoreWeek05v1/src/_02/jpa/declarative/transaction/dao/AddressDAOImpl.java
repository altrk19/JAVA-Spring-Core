package _02.jpa.declarative.transaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import _02.jpa.declarative.transaction.model.Address;

//eðer bu sýnýf için herhangi bir stereotype kullanmazsak bu durumda Spring ilgili bean'i bulamaz.
@Repository
public class AddressDAOImpl implements AddressDAO {
	
	//declarative olarak entityManager objesini @@PersistenceContext ile inject ediyoruz. setter constructor injectiona gerek yok. 
	@PersistenceContext				
	private EntityManager entityManager;

	@Override
	public void insertAddress(Address address) {
		entityManager.persist(address);
	}
}