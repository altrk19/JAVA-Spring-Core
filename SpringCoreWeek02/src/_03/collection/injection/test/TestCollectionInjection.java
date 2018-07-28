package _03.collection.injection.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.collection.injection.model.CollectionInjectionModel;

public class TestCollectionInjection {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("_03.collectionInjection.xml");
		CollectionInjectionModel model =context.getBean("collectionInjectionModel1",CollectionInjectionModel.class);
		//student3 ref ile eklenmiþtir.
		System.out.println(model);       
		
		//herbir key/value çiftine entry denilir
	}
}
