package com.controller;

import java.util.Arrays;

public class LoginController {
	
	public static boolean authenticate(String username, char[] password, String userType) {
		
		if(username.equals("hello") && testPassword(password))
			return true;
		else
			return false;
	}
	
	private static boolean testPassword(char[] password) {
		String testPassword = "";
		
		for(int i=0; i< password.length; i++){
			testPassword += password[i];
		}
		
		Arrays.fill(password, '0');

		if(testPassword.equals("Hello"))
			return true;
		return false;
	}
	
	
}
