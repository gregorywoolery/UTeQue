package com.model;

import java.io.*;
import java.util.Date;

public class Issue implements Serializable{
	//Attributes
	protected static final long serialVersionUID = 1L;
	private String issueId;
	private String type;
	private String status;
	private String studentId;
	private String message;
	private Date issuedAt;
	private Date scheduledDateTime;
	private String repId;
	
	public Issue() {
		this.issueId = "";
		this.type = "";
		this.status = "";
		this.studentId = "";
		this.message = "";
		this.issuedAt = null;
		this.scheduledDateTime = null;
		this.repId = "";	
	}
	
	public Issue(String issueId, String type, String status, 
			String studentId, String message, Date issuedAt,
			Date scheduledDateTime, String repId) {
		
		this.issueId = issueId;
		this.type = type;
		this.status = status;
		this.studentId = studentId;
		this.message = message;
		this.scheduledDateTime = scheduledDateTime;
		this.repId = repId;	
		
	}
	
	//Getters and Setters
	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
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

	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}

	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}
	
	@Override
	public String toString() {
		return "Issue [IssueID=" + issueId + ", Type=" + type + ", Status=" + status + ", Student Id=" + studentId
				+ ", Message=" + message + ", Scheduled DateTime=" + scheduledDateTime
				+ ", RepId=" + repId + "]";
	}

	public void display() {
		System.out.println(toString());
	}

	

}
