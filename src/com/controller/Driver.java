package com.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.client.Client;
import com.view.UserLogin;

public class Driver {
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Client client = new Client(InetAddress.getLocalHost());
			logger.info("Connection established successfully");
				
			
			UserLogin userlogin = new UserLogin(client);			
					
		} catch (UnknownHostException e) {
			logger.error("HOST IP ERROR DETECTED. " + e.getMessage() 
			+ " AT-" + e.getStackTrace());
		}
	}
}
