package _07.aspectj.hibernate.transaction.service;

import java.util.List;

import _07.aspectj.hibernate.transaction.model.Customer;




public interface CustomerService {
	
	public void insertCustomerData(Customer customer);

	public List<Customer> listCustomers();
}