package com.model;

import java.io.*;
import java.util.Date;

public class Issue implements Serializable{

	private static final long serialVersionUID = 5158752509920824080L;

	private String issueID;
	private String type;
	private String status;
	private String studentID;
	private String message;
	private int serviceID;
	private Date issuedAt;
	private Date scheduledDateTime;
	private String repID;
	
	public Issue() {
		this.issueID = "";
		this.type = "";
		this.status = "";
		this.studentID = "";
		this.message = "";
		this.serviceID = -1;
		this.issuedAt = null;
		this.scheduledDateTime = null;
		this.repID = "";	
	}
	
	public Issue(String issueID, String type, String status, 
			String studentID, String message, int serviceID,
			Date issuedAt, Date scheduledDateTime, String repID) {
		
		this.issueID = issueID;
		this.type = type;
		this.status = status;
		this.studentID = studentID;
		this.message = message;
		this.serviceID = serviceID;
		this.issuedAt = issuedAt;
		this.scheduledDateTime = scheduledDateTime;
		this.repID = repID;	
		
	}

	public String getIssueID() {
		return issueID;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getMessage() {
		return message;
	}

	public int getServiceID() {
		return serviceID;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}

	public String getRepID() {
		return repID;
	}

	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public void setRepId(String repID) {
		this.repID = repID;
	}

	@Override
	public String toString() {
		return "Issue [issueID=" + issueID + ", type=" + type + ", status=" + status + ", studentID=" + studentID
				+ ", message=" + message + ", serviceID=" + serviceID + ", issuedAt=" + issuedAt
				+ ", scheduledDateTime=" + scheduledDateTime + ", repID=" + repID + "]";
	}
	
	
	
	

}
