package _02.spring.aop.withXml.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdviceImpl implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("Before !");
		Object retVal = invocation.proceed();
		System.out.println("After ! ");
		return retVal;
	}

}