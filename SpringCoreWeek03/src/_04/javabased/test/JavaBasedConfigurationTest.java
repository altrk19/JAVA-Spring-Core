package _04.javabased.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _04.javabased.configuration.SpringConfiguration;
import _04.javabased.model.Student;

public class JavaBasedConfigurationTest {

	public static void main(String[] args) {
		
		ApplicationContext context= new AnnotationConfigApplicationContext(SpringConfiguration.class);//birden fazla class verebiliyoruz.
		Student student=context.getBean(Student.class);
		System.out.println(student);
	}

}
