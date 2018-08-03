package _01.spring.aop.test;

import org.springframework.aop.framework.ProxyFactory;

import _01.spring.aop.service.AroundAdviceImpl;
import _01.spring.aop.service.LoggerWriter;

public class AroundAdviceTest {
	public static void main(String[] args) {

		LoggerWriter target = new LoggerWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new AroundAdviceImpl());
		pf.setTarget(target);		
		LoggerWriter proxy = (LoggerWriter) pf.getProxy();
		proxy.log();
	}
}

//log metodumuzu calistirdigimizda oncesinde invoke metodu calisacaktir.
//invocation.proceed() metodunu cagirdigimizda log metodu calisacaktir sonrasinda invoke metodu calismasina kaldigi yerden devam edecektir.