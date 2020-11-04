package com.model;

import java.io.*;

public class Issue implements Serializable{
	//Attributes
	protected static final long serialVersionUID = 1L;
	private String IssueID;
	private String type;
	private String status;
	private String studentId;
	private String message;
	private Date scheduledDate;
	private Date scheduledTime;
	private String repId;
	
	//Getters and Setters
	public String getIssueID() {
		return IssueID;
	}

	public void setIssueID(String issueID) {
		IssueID = issueID;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Date scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Date getScheduledTime() {
		return scheduledTime;
	}

	public void setScheduledTime(Date scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}
	
	

	@Override
	public String toString() {
		return "Issue [IssueID=" + IssueID + ", type=" + type + ", status=" + status + ", studentId=" + studentId
				+ ", message=" + message + ", scheduledDate=" + scheduledDate + ", scheduledTime=" + scheduledTime
				+ ", repId=" + repId + "]";
	}

	public void display() {
		System.out.println(toString());
		
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
