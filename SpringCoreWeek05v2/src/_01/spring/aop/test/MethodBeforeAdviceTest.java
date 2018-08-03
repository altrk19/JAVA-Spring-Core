package _01.spring.aop.test;

import org.springframework.aop.framework.ProxyFactory;

import _01.spring.aop.service.LoggerWriter;
import _01.spring.aop.service.MethodBeforeAdviceImpl;

public class MethodBeforeAdviceTest {
	public static void main(String[] args) {

		LoggerWriter target = new LoggerWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new MethodBeforeAdviceImpl());
		pf.setTarget(target);
		LoggerWriter proxy = (LoggerWriter) pf.getProxy();
		proxy.log();
	}

}

//log metodumuzu calistirdigimizda oncesinde before metodu calisacaktir.