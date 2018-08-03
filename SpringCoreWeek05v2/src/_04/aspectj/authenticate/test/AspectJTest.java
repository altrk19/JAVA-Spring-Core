package _04.aspectj.authenticate.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _04.aspectj.authenticate.model.UserData;
import _04.aspectj.authenticate.service.TransactionEngineService;


public class AspectJTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("_04.aspectj.authenticate.xml");

		TransactionEngineService transactionEngineService = context.getBean("transactionEngineService",TransactionEngineService.class);

		UserData userData = new UserData();

		try {
			transactionEngineService.processTransaction(userData);
		} catch (Exception e) {
			System.out.println("AspectJTest#main");
		}

		context.close();
	}
}

//<aop:before method="authenticateBefore" pointcut-ref="pointCutBeforeId" />					�al���r.
//processTransaction metodu �al��madan �nce authenticateBefore metodu �al��t�r�l�r.
//UserAuthenticatorAspect#authenticateBefore is invoked... ekrana bas�l�r 
//hi� bir throw at�lmadan processTransaction metodu �al��t�r�l�r.
//System.out.println("processTransaction is invoked..."); ekrana bas�l�r
//throw new RuntimeException(); kodu �al��t�r�l�r ve throw at�l�r

//<aop:after-throwing method="logger" throwing="exception" pointcut-ref="pointCutAfterThrowingId"  />         bu �al���r �imdi
//processTransaction �al��t�ktan sonra herhangi bir throw at�ld�ysa  loggingServiceAspectId referans ettigi s�n�ftaki logger metodu �al���r
//LoggingServiceAspect#logger is invoked... ekrana bas�l�r
//System.out.println(exception);       ile ekrana RuntimeException bas�l�r
//ard�ndan AspectJTest s�n�f�na geri d�n���r ve catch blogunun i�indeki AspectJTest#main" yaz� ekrana yazd�r�l�r