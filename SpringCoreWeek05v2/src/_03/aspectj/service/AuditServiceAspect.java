package _03.aspectj.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AuditServiceAspect {								//beanlarde log metotlar� nas�l tan�mland�ysa burdada oyle tan�mlanmal�d�r.!!!!!!!!!!!!!!!!!!!
	
	public void logBefore() {									//aop:before
		System.out.println("logBefore is invoked...");
	}
	
	public void logAfter() {									//<aop:after>
		System.out.println("logAfter is invoked...");
	}
	
	public void logAfterReturning(JoinPoint joinPoint, String resultValue) {		//<aop:after-returning>
		System.out.println("logAfterReturning is invoked...");
		System.out.println("Called by : " + joinPoint.getSignature().getName());		//joinpoint yard�m� ile hangi metottan �agr�ld� bunu ogreniriz
		System.out.println("Returned value : " + resultValue);
	}
	
	public void logAfterThrowing(JoinPoint joinPoint, Exception thrownException) {		//bean'de tan�mlanan thrownException'Un ayn�s� yaz�lmal�d�r.

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