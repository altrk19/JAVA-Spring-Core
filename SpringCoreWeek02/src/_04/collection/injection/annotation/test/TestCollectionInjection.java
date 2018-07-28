package _04.collection.injection.annotation.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _04.collection.injection.annotation.model.CollectionInjectionModelAnnotation;

public class TestCollectionInjection {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("_04.collection.injection.annotation.xml");
		
		CollectionInjectionModelAnnotation model =context.getBean("collectionInjectionModelAnnotationId1",CollectionInjectionModelAnnotation.class);
		System.out.println(model);       
		
	}
}
