package _07.aspectj.hibernate.transaction.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _07.aspectj.hibernate.transaction.model.Address;
import _07.aspectj.hibernate.transaction.model.Customer;
import _07.aspectj.hibernate.transaction.service.CustomerService;



public class AspectJHibernateTransactionTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_07.aspectj.hibernate.transaction.xml");

		// get CustomerService bean
		CustomerService customerService = context.getBean(CustomerService.class);

		// prepare Customer and Address data.
		Customer customer = new Customer(1, "Ali", "Bey");
		Address address = new Address(1, "Gebze", "41000", "Kocaeli");
		customer.setAddress(address);

		//
		Customer customer2 = new Customer(2, "Rod", "Johnson");
		Address address2 = new Address(2, "Java Street", "06000", "Ankara");
		customer2.setAddress(address2);

		Customer customer3 = new Customer(3, "James", "Gosling");
		// duplicate Address id , throw exception
		// customers3 record will be rollbacked too.
		Address address3 = new Address(2, "Bagcilar", "34000", "Istanbul");
		customer3.setAddress(address3);

		customerService.insertCustomerData(customer);
		customerService.insertCustomerData(customer2);

		try {
			customerService.insertCustomerData(customer3);
		} catch (Exception e) {
			System.out.println("Rollback...");
			System.out.println(e.getMessage());
		}

		System.out.println("Customer List : ");
		for (Customer customerRecord : customerService.listCustomers()) {
			System.out.println(customerRecord);
		}

		context.close();

	}
}