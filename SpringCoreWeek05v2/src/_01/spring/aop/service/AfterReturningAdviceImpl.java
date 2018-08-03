package _01.spring.aop.service;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

public class AfterReturningAdviceImpl implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("After method: " + method.getName());
	}
}