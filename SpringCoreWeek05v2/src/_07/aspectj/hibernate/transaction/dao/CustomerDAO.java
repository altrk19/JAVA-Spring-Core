package _07.aspectj.hibernate.transaction.dao;

import java.util.List;

import _07.aspectj.hibernate.transaction.model.Customer;




public interface CustomerDAO {

	public void insertCustomer(Customer product);

	public List<Customer> findAllCustomers();
}