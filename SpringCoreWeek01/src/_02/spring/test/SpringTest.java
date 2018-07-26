package _02.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.spring.model.Car;



public class SpringTest {

	public static void main(String[] args) {
		ApplicationContext appContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Car car=appContext.getBean("carId",Car.class);
		car.drive();
	
	}

}
