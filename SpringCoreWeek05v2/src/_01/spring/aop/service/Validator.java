package _01.spring.aop.service;
//ThrowsAdvice i�in yaz�ld� bu s�n�f
public class Validator {
	public void validateAge(int age) throws Exception {
		if (age < 0) {
			throw new ArithmeticException("Not Valid Age");
		} else {
			System.out.println("It is valid age!");
		}
	}

	public int parseAge(String age) {
		return Integer.parseInt(age);
	}

	public void throwRuntimeException() {
		throw new RuntimeException();
	}
}