package _04.javabased.model;

import org.springframework.stereotype.Component;

@Component                           //Student'ta address bean'i tan�mlanmam��sa Spring Containeer @Autowired address ile bu s�n�fa gelir ve null degeri atar.
public class Address {

	private String city;
	private String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + "]";
	}

}
