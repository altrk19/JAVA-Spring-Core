package _02.constructor.injection.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02.constructor.injection.model.ConstructorConfuse;
import _02.constructor.injection.model.Person;

public class TestConstructorInjection {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("_02.constructorInjection.xml");
		Person person1=context.getBean("person1",Person.class);
		Person person12=context.getBean("person1",Person.class);
		
		System.out.println(person1);
		
		System.out.println(person1==person12);
		System.out.println(person1.equals(person12));
		//varsayýlan olarak Spring bean'ler singleton özellik gösterirler.
		
		
		Person person2=context.getBean("person2",Person.class);
		System.out.println(person2);
		
		Person person3=context.getBean("person3",Person.class);
		System.out.println(person3);
		
		ConstructorConfuse confuse=context.getBean("constructorConfuse1",ConstructorConfuse.class);
		System.out.println(confuse);
		
		ConstructorConfuse confuse2=context.getBean("constructorConfuse2",ConstructorConfuse.class);
		System.out.println(confuse2);
		
		context.close();
	}

}
