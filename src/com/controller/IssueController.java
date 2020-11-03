package com.controller;

import com.model.Date;
import com.model.Issue;
import com.model.Users;

import java.io.*;
import java.util.*;


public class IssueController {
	Issue IssueObj = new Issue();
	Date DateObj = new Date();
	private static Scanner input = new Scanner(System.in);
	
	public void addIssue() {
		try {
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
			DateObj.setDay(input.nextInt());
			System.out.println("mm: ");
			DateObj.setMonth(input.nextInt());
			System.out.println("yyyy: ");
			DateObj.setYear(input.nextInt());
			IssueObj.setScheduledDate(DateObj);
			
			System.out.println("Enter Scheduled Time: ");
			System.out.println("HR: ");
			
			System.out.println("MM: ");
			
			System.out.println("AM/PM: ");
			
			//IssueObj.setScheduledDate(DateObj);
			
			System.out.println("Enter Student Services Representative: ");
			IssueObj.setRepId(input.next());
		}catch(InputMismatchException e){
			System.err.println("Wrong input type entered");
		}
			
	}
	
	public void modifyIssue() {
			
	}
	
	public void removeIssue() {
		
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
	

}
