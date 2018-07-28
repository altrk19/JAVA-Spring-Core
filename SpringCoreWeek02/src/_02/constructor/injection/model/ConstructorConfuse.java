package _02.constructor.injection.model;

public class ConstructorConfuse {
	private String name;
	private int age;
	
	public ConstructorConfuse(String name) {
		super();
		this.name = name;
	}
	
	public ConstructorConfuse(int age) {
		super();
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "ConstructorConfuse [name=" + name + ", age=" + age + "]";
	}
}

//Eðer ayrý ayrý constructorlar olursa ve bean tek birtane deðer ile setlenirse ilk hangi constructor yazýlmýþsa o alan setlenir.
//ama tipini belirtirsek bu sorun giderilir.