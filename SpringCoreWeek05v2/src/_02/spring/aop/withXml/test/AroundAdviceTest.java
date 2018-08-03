package _02.spring.aop.withXml.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.spring.aop.withXml.service.LoggerWriter;

public class AroundAdviceTest {
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_02.spring.aop.xml");

		LoggerWriter object = context.getBean("proxyAround", LoggerWriter.class);
		object.log();

		context.close();
	}
}