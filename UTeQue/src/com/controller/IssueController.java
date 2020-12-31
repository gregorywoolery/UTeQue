package com.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Issue;
import com.view.UserLogin;

public class IssueController {
	private static final Logger logger = LogManager.getLogger(IssueController.class);
	private static final int port = 3309;
	
	public static boolean addIssue(Issue issue) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		boolean addIssueSuccess = false;
		
		logger.info("Client Trying to connect using socket at port " + port);
					
		logger.info("Sending ISSUE to SERVER for ADDING");			
			
		String cmd = "ADD-ISSUE";
		logger.info(issue.toString());
		sendDetails.add(cmd);
		sendDetails.add(issue);
		
		addIssueSuccess = (boolean) UserLogin.client.doOperation(sendDetails);
		
		return addIssueSuccess;	
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Issue> getAllIssuesForStudent(String studentID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<Issue> foundStudentIssues = new ArrayList<>();
		
		logger.info("Client Trying to connect using socket at port " + port);
		
		logger.info("Getting ISSUE for STUDENT "+ studentID +" from SERVER");			
		
		String cmd = "GET-STUDENT-ISSUES";

		sendDetails.add(cmd);
		sendDetails.add(studentID);
		
		foundStudentIssues = (ArrayList<Issue>) UserLogin.client.doOperation(sendDetails);
			
		return foundStudentIssues;	
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Issue> getStudentIssuesByService(String studentID, int service) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<Issue> studentIssues = new ArrayList<>();
		
		logger.info("Client Trying to connect using socket at port " + port);
		
		logger.info("Getting ISSUE for STUDENT "+ studentID +" from SERVER");			

		
		String cmd = "GET-STUDENT-ISSUES-BY-SERVICE";

		sendDetails.add(cmd);
		sendDetails.add(studentID);
		sendDetails.add(service);
		
		studentIssues = (ArrayList<Issue>) UserLogin.client.doOperation(sendDetails);

		return studentIssues;	
	}
	
	public static int[] getStudentIssueStats(String studentID){
		ArrayList<Object> sendDetails = new ArrayList<>();
		int[] stats = new int[3];
		
		logger.info("Client Trying to connect using socket at port " + port);
				
		logger.info("Getting ISSUE STATS from STUDENT " + studentID + " from SERVER");		
		
		String cmd = "GET-STUDENT-ISSUE-STATS";

		sendDetails.add(cmd);
		sendDetails.add(studentID);
		
		stats = (int[]) UserLogin.client.doOperation(sendDetails);
				
		return stats;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getMainIssueResponse(String studentID){
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<String> tableData = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + port);
				
		logger.info("Getting JOIN from ISSUE and RESPONSE TABLES for main TABLE");		

		String cmd = "GET-ISSUE-RESPONSE-JOIN";

		sendDetails.add(cmd);
		sendDetails.add(studentID);
		
		tableData = (ArrayList<String>) UserLogin.client.doOperation(sendDetails);

		return tableData;		
		
	}
		
	public static boolean removeIssue(String issueID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		boolean removeIssueSuccess = false;
	
		logger.info("Client Trying to connect using socket at port " + port);
			
		logger.info("Getting JOIN from ISSUE and RESPONSE TABLES for main TABLE");		
		logger.info("Sending ISSUE to SERVER for DELETING");			
			
		String cmd = "DELETE-ISSUE";

		sendDetails.add(cmd);
		sendDetails.add(issueID);
			
		removeIssueSuccess = (boolean) UserLogin.client.doOperation(sendDetails);	
		
		return removeIssueSuccess;	
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Issue> getSearchIssuesForStudent(Issue searchIssue) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<Issue> foundStudentIssues = new ArrayList<>();
		
		logger.info("Client Trying to connect using socket at port " + port);
			
		logger.info("Getting SEARCH ISSUES for STUDENT "+ searchIssue.getStudentID() +" from SERVER");	
			
		String cmd = "GET-STUDENT-SEARCH ISSUES";

		sendDetails.add(cmd);
		sendDetails.add(searchIssue);
			
		foundStudentIssues = (ArrayList<Issue>) UserLogin.client.doOperation(sendDetails);	
		
		return foundStudentIssues;	
	}
	
	
	/*
	 * Students should also be able to view a specific complaint or 
	 * query and all its associated responses.
	 */
	public static Issue viewSpecific(String issueID) {
		ArrayList<Object> sendDetails = new ArrayList<>();

		Issue issue = null;
		
		logger.info("Client Trying to connect using socket at port " + port);
			
		logger.info("Getting Specific ISSUE");		
				
		String cmd = "GET-ISSUE";

		sendDetails.add(cmd);
		sendDetails.add(issueID);
				
		issue = (Issue) UserLogin.client.doOperation(sendDetails);	
		
		return issue;	
	}
	
	public static boolean assignRepresentative(String issueID, String repID){
		ArrayList<Object> sendDetails = new ArrayList<>();
		boolean success = false;
		
		logger.info("Client Trying to connect using socket at port " + port);
			
		logger.info("Assigning REPRESENTATIVE to ISSUE");		
			
			
		String cmd = "ASSIGN-REP";

		sendDetails.add(cmd);
		sendDetails.add(issueID);
		sendDetails.add(repID);
				
		success = (boolean) UserLogin.client.doOperation(sendDetails);	

		return success;
	}
	
		
	public static Object[] getIssueRepStudent(String issueID){
		ArrayList<Object> sendDetails = new ArrayList<>();
		Object[] details = new Object[5];
		
		logger.info("Client Trying to connect using socket at port " + port);
		logger.info("Receiving detials for STAFF ISSUE RESPONSE");		
			
		String cmd = "ISSUE-RESPONSE";

		sendDetails.add(cmd);
		sendDetails.add(issueID);
				
		details = (Object[]) UserLogin.client.doOperation(sendDetails);	
			
		return details;
	}

	public static boolean updateStatus(String issueID) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		boolean updateIssueSuccess = false;
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		
		logger.info("UPDATING STATUS OF ISSUE RECORD");		
			
		String cmd = "UPDATE-ISSUE-STATUS";

		sendDetails.add(cmd);
		sendDetails.add(issueID);
			
		updateIssueSuccess = (boolean) UserLogin.client.doOperation(sendDetails);	
		
		return updateIssueSuccess;	
	}
 




	


}
