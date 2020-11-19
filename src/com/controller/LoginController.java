package com.controller;

import java.util.Arrays;
import com.services.UTeQueDBOperations;

public class LoginController {
	
	public static boolean authenticate(String username, char[] password, String userType) {
		boolean result = false;
		if(userType.equals("Student")) {
			result = UTeQueDBOperations.loginStudent(username, String.valueOf(password));
			return result;
		}else if(userType.equals("Rep")) {
			result = UTeQueDBOperations.loginRep(username, String.valueOf(password));
			return result;
			
		}else if(userType.equals("Agent")) {
			result = UTeQueDBOperations.loginAgent(username, String.valueOf(password));
			return result;
			
		}
		else
			return false;
	}
	
	/*
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
	*/
	
}
