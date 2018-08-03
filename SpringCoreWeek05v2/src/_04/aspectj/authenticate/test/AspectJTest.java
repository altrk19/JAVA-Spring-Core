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

//<aop:before method="authenticateBefore" pointcut-ref="pointCutBeforeId" />					çalýþýr.
//processTransaction metodu çalýþmadan önce authenticateBefore metodu çalýþtýrýlýr.
//UserAuthenticatorAspect#authenticateBefore is invoked... ekrana basýlýr 
//hiç bir throw atýlmadan processTransaction metodu çalýþtýrýlýr.
//System.out.println("processTransaction is invoked..."); ekrana basýlýr
//throw new RuntimeException(); kodu çalýþtýrýlýr ve throw atýlýr

//<aop:after-throwing method="logger" throwing="exception" pointcut-ref="pointCutAfterThrowingId"  />         bu çalýþýr þimdi
//processTransaction çalýþtýktan sonra herhangi bir throw atýldýysa  loggingServiceAspectId referans ettigi sýnýftaki logger metodu çalýþýr
//LoggingServiceAspect#logger is invoked... ekrana basýlýr
//System.out.println(exception);       ile ekrana RuntimeException basýlýr
//ardýndan AspectJTest sýnýfýna geri dönüþür ve catch blogunun içindeki AspectJTest#main" yazý ekrana yazdýrýlýr