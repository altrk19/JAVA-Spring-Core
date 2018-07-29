package _01.autowired.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.autowired.model.Employee;

public class TestAutowired {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("_01.autowired.xml");
		Employee employee=context.getBean("employee1",Employee.class);
		System.out.println(employee);
	}

}
