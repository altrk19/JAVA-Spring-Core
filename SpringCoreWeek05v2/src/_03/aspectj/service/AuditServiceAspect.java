package _03.aspectj.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AuditServiceAspect {								//beanlarde log metotları nasıl tanımlandıysa burdada oyle tanımlanmalıdır.!!!!!!!!!!!!!!!!!!!
	
	public void logBefore() {									//aop:before
		System.out.println("logBefore is invoked...");
	}
	
	public void logAfter() {									//<aop:after>
		System.out.println("logAfter is invoked...");
	}
	
	public void logAfterReturning(JoinPoint joinPoint, String resultValue) {		//<aop:after-returning>
		System.out.println("logAfterReturning is invoked...");
		System.out.println("Called by : " + joinPoint.getSignature().getName());		//joinpoint yardımı ile hangi metottan çagrıldı bunu ogreniriz
		System.out.println("Returned value : " + resultValue);
	}
	
	public void logAfterThrowing(JoinPoint joinPoint, Exception thrownException) {		//bean'de tanımlanan thrownException'Un aynısı yazılmalıdır.

		System.out.println("logAfterThrowing is invoked...!");
		System.out.println("Called by  : " + joinPoint.getSignature().getName());					
		System.out.println("Exception : " + thrownException);

	}
	
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {			//<aop:around>

		System.out.println("logAround is invoked...");
		System.out.println("Called by : " + joinPoint.getSignature().getName());
		System.out.println("Around before is running!");

		joinPoint.proceed();

		System.out.println("Around after is running!");
		
	}
}