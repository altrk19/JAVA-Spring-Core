package _07.aspectj.hibernate.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _07.aspectj.hibernate.transaction.dao.AddressDAO;
import _07.aspectj.hibernate.transaction.dao.CustomerDAO;
import _07.aspectj.hibernate.transaction.model.Customer;





@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AddressDAO addressDao;

	@Transactional
	@Override
	public void insertCustomerData(Customer customer) {
		customerDAO.insertCustomer(customer);
		addressDao.insertAddress(customer.getAddress());
	}

	@Transactional
	@Override	
	public List<Customer> listCustomers() {
		return customerDAO.findAllCustomers();
	}

}