package org.student.service;

public class UserServiceImpl implements UserService {

	public boolean isValid(String username, String password) {
		if (username.equals("raju@gmail.com") && password.equals("1234")) {
			return true;
		}
		return false;
	}
}