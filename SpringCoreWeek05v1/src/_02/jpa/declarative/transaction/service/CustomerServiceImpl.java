package _02.jpa.declarative.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _02.jpa.declarative.transaction.dao.AddressDAO;
import _02.jpa.declarative.transaction.dao.CustomerDAO;
import _02.jpa.declarative.transaction.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AddressDAO addressDao;

	@Transactional      //bu annonation sayesinde dao da transaciton kodu yazýlmadý.
	@Override
	public void insertCustomerData(Customer customer) {                               //burada address eklenirken hata verirse  Customerda eklenmez. rollback yapýlýr.
		customerDAO.insertCustomer(customer);
		addressDao.insertAddress(customer.getAddress());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> listCustomers() {
		return customerDAO.findAllCustomers();

	}

}