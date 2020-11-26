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

import com.model.Issue;

public class IssueController {
	private static final Logger logger = LogManager.getLogger(IssueController.class);
	private static final int port = 3309;
	
	public static boolean addIssue(Issue issue) {
		boolean addIssueSuccess = false;
		
		logger.info("Client Trying to connect using socket at port " + port);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Sending ISSUE to SERVER for ADDING");			
			
			os.flush();
			os.writeObject("ADD-ISSUE");
			os.flush();
			os.writeObject(issue);
			os.flush();
			
			addIssueSuccess = is.readBoolean();

		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		} catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		}
		
		return addIssueSuccess;	
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Issue> getAllIssuesForStudent(String studentID) {
		ArrayList<Issue> foundStudentIssues = new ArrayList<>();
		logger.info("Client Trying to connect using socket at port " + port);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Getting ISSUE for STUDENT "+ studentID +" from SERVER");			

			os.flush();
			String getString = "GET-STUDENT-ISSUES";
			os.writeObject(getString);
			os.flush();
			os.writeObject(String.valueOf(studentID));
			os.flush();
			
			foundStudentIssues =  (ArrayList<Issue>) is.readObject();
			
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
		
		return foundStudentIssues;	
	}
	
	public static int[] getStudentIssueStats(String studentID){
		int[] stats = new int[3];
		
		logger.info("Client Trying to connect using socket at port " + port);
	
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Getting ISSUE STATS from STUDENT " + studentID + " from SERVER");		
			
			os.writeObject("GET-STUDENT-ISSUE-STATS");
			os.writeObject(studentID);

			stats =  (int[]) is.readObject();
			
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
		
		return stats;
	}
	
	public void removeIssue(String issueId) {
		
	}
	
	public void viewSpecific(String type, String id) {
			/*
			 * - Students should also be able to view a specific complaint or query and all its associated responses.
			 */
			
	}
	
		
	/*
	 * Employees should be able to view a list of services on the dashboard 
	 * along with the number of resolved and outstanding queries and complaints.
	 */
	public int viewResolvedQueries() {
			return 0;
	}
	public int viewResolvedComplaints() {
			return 0;
	}
	public int viewOutstandQueries() {
			return 0;
	}
	public int viewOutstandComplaints() {
			return 0;
	}



	


}
