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
	
	//processTransaction metodundan �nce authanticate metodu �al��acak. authanticate yapmas� i�in userData'y� metoda g�nderiyoruz.(xml'de)  ilk �nce authanticate yapm�yoruz
	
	//burada processTransaction gibi birs�r� metot olsa herbiri i�in authanticate i�lemini manuel olarak yazmak zahmetli olur. ama bizim kulland�g�m�z y�ntemde direk y�nlendirme oluyor. daha basit.
	
}