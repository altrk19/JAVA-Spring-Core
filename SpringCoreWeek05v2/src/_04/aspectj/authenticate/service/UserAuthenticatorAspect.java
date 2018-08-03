package _04.aspectj.authenticate.service;

import _04.aspectj.authenticate.exception.UserDataException;
import _04.aspectj.authenticate.model.UserData;

public class UserAuthenticatorAspect {

	public void authenticateBefore(UserData userData) {

		System.out.println("UserAuthenticatorAspect#authenticateBefore is invoked...");

		UserAuthenticator authenticator = new UserAuthenticator();
		try {
			authenticator.authenticateUser(userData);
		} catch (UserDataException e) {
			System.out.println("Exception caught!");
			System.out.println(e.getErrorMessage());

		}
	}
}