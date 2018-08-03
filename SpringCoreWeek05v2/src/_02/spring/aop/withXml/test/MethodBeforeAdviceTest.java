package _02.spring.aop.withXml.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.spring.aop.withXml.service.LoggerWriter;

public class MethodBeforeAdviceTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_02.spring.aop.xml");
		
		LoggerWriter object = context.getBean("proxyBefore", LoggerWriter.class);
		object.log();

		context.close();
	}

}