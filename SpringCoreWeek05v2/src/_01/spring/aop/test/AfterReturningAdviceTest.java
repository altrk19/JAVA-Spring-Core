package _01.spring.aop.test;

import org.springframework.aop.framework.ProxyFactory;

import _01.spring.aop.service.AfterReturningAdviceImpl;
import _01.spring.aop.service.LoggerWriter;

public class AfterReturningAdviceTest {
	public static void main(String[] args) {

		LoggerWriter target = new LoggerWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new AfterReturningAdviceImpl());
		pf.setTarget(target);
		LoggerWriter proxy = (LoggerWriter) pf.getProxy();
		proxy.log();
	}

}

//log metodumuzu calistirdigimizda sonrasinda afterReturning metodu calisacaktir.