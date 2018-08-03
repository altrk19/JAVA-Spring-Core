package _04.aspectj.authenticate.service;

import _04.aspectj.authenticate.model.UserData;

public class TransactionEngineService {

	public void processTransaction(UserData userData) {

		// business logic	
		System.out.println("processTransaction is invoked...");
		//
		//

		throw new RuntimeException();

	}
	
	//processTransaction metodundan önce authanticate metodu çalýþacak. authanticate yapmasý için userData'yý metoda gönderiyoruz.(xml'de)  ilk önce authanticate yapmýyoruz
	
	//burada processTransaction gibi birsürü metot olsa herbiri için authanticate iþlemini manuel olarak yazmak zahmetli olur. ama bizim kullandýgýmýz yöntemde direk yönlendirme oluyor. daha basit.
	
}