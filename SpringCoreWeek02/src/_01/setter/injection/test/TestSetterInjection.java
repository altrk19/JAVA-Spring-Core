package _01.setter.injection.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01.setter.injection.model.Employee;

public class TestSetterInjection {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("_01.setterInjection.xml");
		
		Employee employee=context.getBean("emp1",Employee.class);
		System.out.println(employee);
		
		Employee employee2=context.getBean("emp2",Employee.class);
		System.out.println(employee2);
		
		Employee employee3=context.getBean("emp3",Employee.class);
		System.out.println(employee3);
		
		Employee employee4=context.getBean("emp4",Employee.class);
		System.out.println(employee4);
		
		context.close();
	}

}
