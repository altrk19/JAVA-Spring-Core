package _03.hibernate.declarative.transaction.dao;

import java.util.List;

import _03.hibernate.declarative.transaction.model.Customer;



public interface CustomerDAO {

	public void insertCustomer(Customer product);

	public List<Customer> findAllCustomers();
}