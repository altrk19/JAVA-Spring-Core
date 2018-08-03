package _02.spring.aop.withXml.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.spring.aop.withXml.service.Validator;


public class ThrowsAdviceTest {
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_02.spring.aop.xml");

		Validator validator = context.getBean("proxyThrows", Validator.class);
		try {
			validator.validateAge(-10);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException#catch\n");
		}

		try {
			validator.parseAge("Exception");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException#catch\n");
		}

		try {
			validator.throwRuntimeException();
		} catch (RuntimeException e) {
			System.out.println("RuntimeException#catch\n");
		}

		context.close();

	}

}