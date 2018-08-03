package _04.aspectj.authenticate.service;

public class LoggingServiceAspect {

	public void logger(Exception exception) {
		System.out.println("LoggingServiceAspect#logger is invoked...");
		System.out.println(exception);
	}

}