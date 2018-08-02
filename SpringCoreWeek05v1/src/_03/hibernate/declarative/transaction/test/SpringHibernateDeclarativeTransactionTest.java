package _03.hibernate.declarative.transaction.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.hibernate.declarative.transaction.model.Address;
import _03.hibernate.declarative.transaction.model.Customer;
import _03.hibernate.declarative.transaction.service.CustomerService;


public class SpringHibernateDeclarativeTransactionTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_03.hibernate.declarative.transaction.xml");

		// get CustomerService bean
		CustomerService customerService = context.getBean(CustomerService.class);

		// prepare Customer and Address data.
		Customer customer = new Customer(1, "Ali", "Bey");
		Address address = new Address(1, "Gebze", "41000", "Kocaeli");
		customer.setAddress(address);

		//
		Customer customer2 = new Customer(2, "Umut", "Can");
		Address address2 = new Address(2, "Java Street", "10000", "Balikesir");
		customer2.setAddress(address2);

		Customer customer3 = new Customer(3, "Ata", "Kan");
		// duplicate Address id , throw exception
		// customers3 record will be rollbacked too.
		Address address3 = new Address(2, "Of", "61000", "Trabzon");                //id'ler ayný oldugu için veritabanýna eklenmez
		customer3.setAddress(address3);

		customerService.insertCustomerData(customer);
		customerService.insertCustomerData(customer2);

		try {
			customerService.insertCustomerData(customer3);                          //addresste hata verdigi çin rollback yapýlýr.
		} catch (Exception e) {
			System.out.println("Rollback...");
			System.out.println(e.getMessage());
		}

		//
		System.out.println("Customer List : ");
		for (Customer customerRecord : customerService.listCustomers()) {
			System.out.println(customerRecord);
		}

		context.close();

	}
}