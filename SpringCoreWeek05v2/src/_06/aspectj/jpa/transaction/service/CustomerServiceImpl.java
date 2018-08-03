package _06.aspectj.jpa.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _06.aspectj.jpa.transaction.dao.AddressDAO;
import _06.aspectj.jpa.transaction.dao.CustomerDAO;
import _06.aspectj.jpa.transaction.model.Customer;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AddressDAO addressDao;

	@Override
	public void insertCustomerData(Customer customer) {
		customerDAO.insertCustomer(customer);
		addressDao.insertAddress(customer.getAddress());
	}

	@Override
	public List listCustomers() {
		return customerDAO.findAllCustomers();
	}

}
