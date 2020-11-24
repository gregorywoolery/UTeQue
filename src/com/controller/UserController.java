package com.controller;

import java.util.Date;

import com.model.Student;
import com.model.User;
import com.services.UTeQueDBOperations;

public class UserController {
	
	public static User getCurrentUser(String username, String userType) {
		 User currentUser = new User();
		 currentUser = UTeQueDBOperations.getUser(username, userType);
		
		return currentUser;
	}
}
