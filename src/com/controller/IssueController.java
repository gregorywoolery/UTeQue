package com.controller;

import java.util.ArrayList;

import com.model.Issue;
import com.services.UTeQueDBOperations;



public class IssueController {
	
	public static boolean addIssue(Issue issue) {
		boolean added = UTeQueDBOperations.insertIssue(issue);
		return added;	
	}
	
	public void updateIssue(String issueId) {
			
	}
	
	public void removeIssue(String issueId) {
		
	}
		
	//Methods
	public void viewAll(String type){
	/** 
	 * Students should be able to view all past complaints or queries in a list. 
	 * For each complaint or query in the list, the last response date and who provided the response, 
	 * should be shown.
	 */	
	}
	
	public static ArrayList<Issue> getAllIssuesForStudent(String studentID) {
		ArrayList<Issue> foundStudentIssues =  UTeQueDBOperations.getAllIssuesForStudent(studentID);
		return foundStudentIssues;
	}
	
	public static int[] getStudentIssueStats(String studentID){
		int[] stats = UTeQueDBOperations.getUserIssueStats(studentID);
		return stats;
	}
	
	public void viewSpecific(String type, String id) {
			/*
			 * - Students should also be able to view a specific complaint or query and all its associated responses.
			 */
			
	}
	
		
		/*
		 * - Employees should be able to view a list of services on the dashboard 
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
