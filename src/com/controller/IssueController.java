package com.controller;

//import com.model.Date;
import com.model.Issue;
import com.model.Users;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java.io.*;
import java.util.*;


public class IssueController {
	Issue IssueObj = new Issue();
	Date DateObj = new Date();
	private static Scanner input = new Scanner(System.in);
	DateFormat issueFormat = new SimpleDateFormat("yymmddhhmmss");
	String dateString = issueFormat.format(new Date()).toString();	
	
	
	@SuppressWarnings("deprecation")
	public void addIssue() {
		try {
			String issueId = dateString; // Assign Issue ID based on (yy-mm-dd-hh-mm-ss) format of current date and time
			System.out.println("Enter Type: ");
			IssueObj.setType(input.next());
			System.out.println("Enter Status: ");
			IssueObj.setStatus(input.next());
			System.out.println("Enter Student ID: ");
			IssueObj.setStudentId(input.next());
			System.out.println("Enter Message: ");
			IssueObj.setMessage(input.next());
			
			System.out.println("Enter Scheduled Date: ");
			System.out.println("dd: ");
			DateObj.setDate(input.nextInt());
			System.out.println("mm: ");
			DateObj.setMonth(input.nextInt());
			System.out.println("yyyy: ");
			DateObj.setYear(input.nextInt());
			
			System.out.println("Enter Scheduled Time: ");
			System.out.println("HR: ");
			DateObj.setHours(input.nextInt());
			System.out.println("MM: ");
			DateObj.setMinutes(input.nextInt());
			//System.out.println("AM/PM: ");
			
			IssueObj.setScheduledDateTime(DateObj);
			
			System.out.println("Enter Student Services Representative: ");
			IssueObj.setRepId(input.next());

		}catch(InputMismatchException e){
			System.err.println("Wrong Input Type Entered");
		}
			
	}
	
	public void modifyIssue(String issueId) {
			
	}
	
	public void removeIssue(String issueId) {
		
	}
	
	public static void writeFunct(ArrayList<Issue> IssueList) {
		try {
			//Open File
			FileOutputStream fos = new FileOutputStream("Issue.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Write to File
			oos.writeObject(IssueList);
			
			//Close File
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Issue> Issue(){
		ArrayList<Issue> IssueList = new ArrayList<Issue>();

        try {
        	//Open File
        	FileInputStream fis = new FileInputStream("Issue.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
			
            // Read File
            IssueList = (ArrayList<Issue>) ois.readObject();
			
			if(IssueList==null)
				System.out.println("****No Record Found****"+"\n");
			
			for (Issue i : IssueList) {
	            System.out.println(i);
	        }
			//Close File
			ois.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
       return IssueList;
		
	}
	//Methods
	public void viewAll(String type){
			/*
			 * - Students should be able to view all past complaints or queries in a list. 
			 	  For each complaint or query in the list, the last response date and who provided the response, 
			 	  should be shown.
			 */	
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
