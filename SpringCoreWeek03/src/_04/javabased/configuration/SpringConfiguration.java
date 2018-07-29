//java tabanl� configuration nas�l yap�l�r onu ogreniyoruz.XML kullanm�yoruz.
package _04.javabased.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import _04.javabased.model.Address;
import _04.javabased.model.Student;

@Configuration
//@Configuration annotation'u ekledigimizde bu s�n�fta bir yada birden fazla @Bean tan�m� var anlam�na gelir.
@PropertySource(value="student.properties") //properties dosyas�n�n ad� verildi.
@ComponentScan(basePackages="_04.javabased.model")//@bean annotationlar�nda aranacak s�n�f� bildiriyoruz.
public class SpringConfiguration {
	@Autowired
	private Environment environment;
	
	@Bean                                     //Xml deki bean etiketine kar��l�k d��er.
	public Student getStudent() {
		Student student=new Student();
		//student.setName("ali");
		//student.setSurname("bey");
		
		//name ve surnmae bilgisini properties dosyas�ndan okuyal�m.
		String name=environment.getProperty("name");
		String surname=environment.getProperty("surname");
		student.setName(name);
		student.setSurname(surname);
		return student;
	}
	
	
	//metotlar� biz �ag�rm�yoruz Spring kendi otomatik oalrak �ag�r�yor.
	
	/*@Bean
	public Address getAddress() {
		Address address=new Address();
		address.setCity("kocaeli");
		address.setCountry("turkey");
		return address;
	}*/
}
//environment autowired edip d��ar�dan bir properties dosyas�n� okuyabiliyoruz. veritaban� bilgileri properties dosyas�nda olabilir.
//student.properties dosyas�n� source folder alt�na koyabiliriz.
//file ad�nda package a�arsak eri�mek i�in @PropertySource(value="file/student.properties")