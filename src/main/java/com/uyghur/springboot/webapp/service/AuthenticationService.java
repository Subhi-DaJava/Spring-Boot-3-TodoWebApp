package com.uyghur.springboot.webapp.service;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("uyghurJava");
		boolean isValidPassword = password.equalsIgnoreCase("shifir");
		
		return isValidUsername && isValidPassword;
	}
}
