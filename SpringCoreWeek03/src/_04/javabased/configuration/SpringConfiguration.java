//java tabanlý configuration nasýl yapýlýr onu ogreniyoruz.XML kullanmýyoruz.
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
//@Configuration annotation'u ekledigimizde bu sýnýfta bir yada birden fazla @Bean tanýmý var anlamýna gelir.
@PropertySource(value="student.properties") //properties dosyasýnýn adý verildi.
@ComponentScan(basePackages="_04.javabased.model")//@bean annotationlarýnda aranacak sýnýfý bildiriyoruz.
public class SpringConfiguration {
	@Autowired
	private Environment environment;
	
	@Bean                                     //Xml deki bean etiketine karþýlýk düþer.
	public Student getStudent() {
		Student student=new Student();
		//student.setName("ali");
		//student.setSurname("bey");
		
		//name ve surnmae bilgisini properties dosyasýndan okuyalým.
		String name=environment.getProperty("name");
		String surname=environment.getProperty("surname");
		student.setName(name);
		student.setSurname(surname);
		return student;
	}
	
	
	//metotlarý biz çagýrmýyoruz Spring kendi otomatik oalrak çagýrýyor.
	
	/*@Bean
	public Address getAddress() {
		Address address=new Address();
		address.setCity("kocaeli");
		address.setCountry("turkey");
		return address;
	}*/
}
//environment autowired edip dýþarýdan bir properties dosyasýný okuyabiliyoruz. veritabaný bilgileri properties dosyasýnda olabilir.
//student.properties dosyasýný source folder altýna koyabiliriz.
//file adýnda package açarsak eriþmek için @PropertySource(value="file/student.properties")