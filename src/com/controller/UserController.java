package com.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.client.Client;
import com.model.Student;
import com.model.StudentServicesRep;
import com.model.User;
import com.view.UserLogin;

public class UserController {
	private static User currentUser = new User();
	private static boolean found = false;
	private static final Logger logger = LogManager.getLogger(IssueController.class);
	
	public static void setCurrentUser(String username, String userType) {		
		currentUser.setID(username);
		currentUser.setType(userType);

	}
	
	public static User getCurrentUser(Client client) {
		if(UserLogin.currentUser.getGender() == null && !found) {
			currentUser = getUserInfo(client);
			found = true;
			currentUser.setType(UserLogin.currentUser.getType());
		}
		logger.info("Returning current User");
		
		return currentUser;
	}
	
	public static void setCurrentUserNull() {
		logger.info("Removing current User");
		currentUser = null;
		found = false;
	}
	
	private static User getUserInfo(Client client) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		final int port = 3309;
		
		logger.info("Client Trying to connect using socket at port " + port);
		logger.info("Recieving User Information");			
			
		String cmd = "GET-CURRENT-USER";
		
		sendDetails.add(cmd);
		sendDetails.add(UserLogin.currentUser);
		
		currentUser = (User) client.doOperation(sendDetails);
		
		return currentUser;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getAllAvailableRepresentative(Client client){
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<String> representative = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + 3309);			
		logger.info("Receving List of STUDENT SERVICES REPRESENTATIVE from SERVER");			
		
		String cmd ="GET-REPS";
		
		sendDetails.add(cmd);
		
		representative = (ArrayList<String>) client.doOperation(sendDetails);
		
		
		return representative;
	}
	
	public static Student getStudent(Client client, String studentID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		Student student = new Student();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		logger.info("Receving List of STUDENT from SERVER");			
		
		String cmd = "GET-STUDENT";
		
		sendDetails.add(cmd);
		sendDetails.add(studentID);
		
		student = (Student) client.doOperation(sendDetails);
		
		return student;
	}
	
	public static StudentServicesRep getRep(Client client, String repID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		StudentServicesRep rep = new StudentServicesRep();
		logger.info("Client Trying to connect using socket at port " + 3309);
			
		logger.info("Receving List of STUDENT from SERVER");			
		
		String cmd = "GET-REP";
		
		sendDetails.add(cmd);
		sendDetails.add(repID);
		
		rep = (StudentServicesRep) client.doOperation(sendDetails);
		
		return rep;
	}
}
