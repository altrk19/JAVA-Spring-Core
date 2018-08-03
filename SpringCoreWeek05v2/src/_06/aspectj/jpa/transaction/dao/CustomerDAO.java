package _06.aspectj.jpa.transaction.dao;

import java.util.List;

import _06.aspectj.jpa.transaction.model.Customer;



public interface CustomerDAO {

	public void insertCustomer(Customer product);

	public List<Customer> findAllCustomers();
}