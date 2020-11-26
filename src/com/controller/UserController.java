package com.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.User;

public class UserController {
	private static User currentUser = new User();
	private static String username;
	private static String userType;
	
	private static final Logger logger = LogManager.getLogger(IssueController.class);

	public static String getUsername() {
		return username;
	}

	public static String getUserType() {
		return userType;
	}
	
	public static void setCurrentUser(String username, String userType) {		
		currentUser = new User(username, userType);

	}
	
	public static User getCurrentUser() {
		if(currentUser.getLastname() == null)
			currentUser = getUserInfo();
		logger.info("Returning current User");
		return currentUser;
	}
	
	public static void setCurrentUserNull() {
		currentUser = null;
	}
	
	private static User getUserInfo() {
		final int port = 3309;
		logger.info("Client Trying to connect using socket at port " + port);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Recieving User Information");			
			
			os.writeObject("GET-CURRENT-USER");
			os.writeObject(currentUser);
			
			currentUser = (User) is.readObject();

		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		} catch (ClassNotFoundException e) {
			logger.error("ERROR OCCUER - " + e.getMessage()
			+ e.getStackTrace());
		} catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		} 
		
		return currentUser;
	}
}
