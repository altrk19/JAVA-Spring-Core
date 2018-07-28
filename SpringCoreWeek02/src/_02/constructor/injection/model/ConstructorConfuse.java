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

//E�er ayr� ayr� constructorlar olursa ve bean tek birtane de�er ile setlenirse ilk hangi constructor yaz�lm��sa o alan setlenir.
//ama tipini belirtirsek bu sorun giderilir.