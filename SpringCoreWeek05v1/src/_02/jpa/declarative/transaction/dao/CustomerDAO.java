package _02.jpa.declarative.transaction.dao;

import java.util.List;

import _02.jpa.declarative.transaction.model.Customer;


public interface CustomerDAO {

	public void insertCustomer(Customer product);

	public List<Customer> findAllCustomers();
}