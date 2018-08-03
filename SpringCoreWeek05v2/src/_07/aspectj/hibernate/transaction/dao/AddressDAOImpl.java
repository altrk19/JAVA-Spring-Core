package _07.aspectj.hibernate.transaction.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _07.aspectj.hibernate.transaction.model.Address;



//eðer bu sýnýf için herhangi bir stereotype kullanmazsak bu durumda Spring ilgili bean'i bulamaz.
@Repository
public class AddressDAOImpl implements AddressDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insertAddress(Address address) {
		Session session = getCurrentSession();
		session.persist(address);
	}
}