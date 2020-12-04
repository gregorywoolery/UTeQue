package com.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Student;
import com.model.StudentServicesRep;
import com.model.User;
import com.view.UserLogin;

public class UserController {
	private static User currentUser = new User();
	private static boolean found = false;
	private static final Logger logger = LogManager.getLogger(IssueController.class);
	private static final int port = 3309;
	
	public static void setCurrentUser(String username, String userType) {		
		currentUser.setID(username);
		currentUser.setType(userType);

	}
	
	public static User getCurrentUser() {
		if(UserLogin.currentUser.getGender() == null && !found) {
			currentUser = getUserInfo();
			found = true;
			currentUser.setType(UserLogin.currentUser.getType());
		}
		logger.info("Returning current User");
		
		return currentUser;
	}
	
	public static void setCurrentUserNull() {
		logger.info("Removing current User");
		currentUser = new User();
		found = false;
	}
	
	private static User getUserInfo() {
		ArrayList<Object> sendDetails = new ArrayList<>();
		final int port = 3309;
		
		logger.info("Client Trying to connect using socket at port " + port);
		logger.info("Recieving User Information");			
			
		String cmd = "GET-CURRENT-USER";
		
		sendDetails.add(cmd);
		sendDetails.add(UserLogin.currentUser);
		
		currentUser = (User) UserLogin.client.doOperation(sendDetails);
		
		return currentUser;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getAllAvailableRepresentative(){
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<String> representative = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + 3309);			
		logger.info("Receving List of STUDENT SERVICES REPRESENTATIVE from SERVER");			
		
		String cmd ="GET-REPS";
		
		sendDetails.add(cmd);
		
		representative = (ArrayList<String>) UserLogin.client.doOperation(sendDetails);
		
		
		return representative;
	}
	
	public static Student getStudent(String studentID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		Student student = new Student();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		logger.info("Receving List of STUDENT from SERVER");			
		
		String cmd = "GET-STUDENT";
		
		sendDetails.add(cmd);
		sendDetails.add(studentID);
		
		student = (Student) UserLogin.client.doOperation(sendDetails);
		
		return student;
	}
	
	public static StudentServicesRep getRep(String repID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		StudentServicesRep rep = new StudentServicesRep();
		logger.info("Client Trying to connect using socket at port " + 3309);
			
		logger.info("Receving List of STUDENT from SERVER");			
		
		String cmd = "GET-REP";
		
		sendDetails.add(cmd);
		sendDetails.add(repID);
		
		rep = (StudentServicesRep) UserLogin.client.doOperation(sendDetails);
		
		return rep;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<User> getOnlineStudents(){
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<User> onlineStudents = new ArrayList<>();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		logger.info("Receving List of STUDENT from SERVER");			
		
		String cmd = "GET-ONLINE-STUDENTS";

		sendDetails.add(cmd);
		
		onlineStudents = (ArrayList<User>) UserLogin.client.doOperation(sendDetails);
		
		return onlineStudents;
	}

	//Retrieves the Student Details by IssueID
	public static Student getStudentDetailsByIssueID(String issueID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		Student studentDetails = new Student();
		
		logger.info("Client Trying to connect using socket at port " + port);
		logger.info("Getting Student RECORD for Student Details Panel");		

		String cmd = "GET-STUDENT-DETAILS";

		sendDetails.add(cmd);
		sendDetails.add(issueID);

		studentDetails = (Student) UserLogin.client.doOperation(sendDetails);

		return studentDetails;		
	}

}
