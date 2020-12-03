package com.controller;

import java.util.ArrayList;

import com.model.User;
import com.view.UserLogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	private static final int port = 3309;
	
	
	public static boolean authenticate(String username, char[] password, String userType) {

		ArrayList<Object> sendDetails = new ArrayList<>();
		
		boolean authenticateSuccess = false;
		userType = userType.toUpperCase();
	
		logger.info("Client Trying to connect using socket at port " + port);
		logger.info("Trying to AUTHENTICATE USER ON SYSTEM");		
		
		String cmd = "AUTHENTICATE";
		
		sendDetails.add(cmd);
		sendDetails.add(new User(username, password, userType));
		
		authenticateSuccess = (boolean) UserLogin.client.doOperation(sendDetails);

		logger.info("AUTHENTICATION RECIEVED BASED ON USER CREDENTIALS");
					
		return authenticateSuccess;
	}
	
}
