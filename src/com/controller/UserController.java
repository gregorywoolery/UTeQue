package com.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
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
		currentUser = null;
		found = false;
	}
	
	private static User getUserInfo() {
		final int port = 3309;
		logger.info("Client Trying to connect using socket at port " + port);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Recieving User Information");			
			
			os.flush();
			os.writeObject("GET-CURRENT-USER");
			os.flush();
			os.writeObject(UserLogin.currentUser);
			os.flush();
			
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
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getAllAvailableRepresentative(){
		ArrayList<String> representative = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receving List of STUDENT SERVICES REPRESENTATIVE from SERVER");			
			
			os.writeObject("GET-REPS");
			os.flush();
			
			representative = (ArrayList<String>) is.readObject();

		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		} catch (ClassNotFoundException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
			+ e.getStackTrace());			
		} catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		}
		
		return representative;
	}
	
	public static Student getStudent(String studentID) {
		Student student = new Student();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receving List of STUDENT from SERVER");			
			
			System.out.print("IN GET STUDENT\n");
			
			os.writeObject("GET-STUDENT");
			os.flush();
			os.writeObject(studentID);
			
			student = (Student) is.readObject();

			System.out.print("STUDENT REVIEVED\n");
			
		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		} catch (ClassNotFoundException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
			+ e.getStackTrace());			
		} catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		}
		
		return student;
	}
	
	public static StudentServicesRep getRep(String repID) {
		StudentServicesRep rep = new StudentServicesRep();
		logger.info("Client Trying to connect using socket at port " + 3309);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receving List of STUDENT from SERVER");			
			
			System.out.print("IN GET STUDENT\n");
			
			os.writeObject("GET-REP");
			os.flush();
			os.writeObject(repID);
			
			rep = (StudentServicesRep) is.readObject();

			System.out.print("STUDENT REVIEVED\n");
			
		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		} catch (ClassNotFoundException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
			+ e.getStackTrace());			
		} catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		}
		
		return rep;
	}

	//Retrieves the Student Details by IssueID
	public static Student getStudentDetailsByIssueID(String issueID) {
			Student studentDetails = new Student();
			
			logger.info("Client Trying to connect using socket at port " + port);
			
			try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
					ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
			){
				
				logger.info("Getting Student RECORD for Student Details Panel");		
				System.out.println("User Controller TEST****");
				os.writeObject("GET-STUDENT-DETAILS");
				os.flush();
				os.writeObject(issueID);
	
				studentDetails = (Student) is.readObject();
				
			} catch (UnknownHostException e) {
				logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
								+ e.getStackTrace());
				
			} catch (ClassNotFoundException e) {
				logger.error("ERROR OCCURED - " + e.getMessage()
								+ e.getStackTrace());
				
			} catch (IOException e) {
				logger.error("ERROR OCCURED - " + e.getMessage()
								+ e.getStackTrace());
			}
			
			return studentDetails;		
	}

}
