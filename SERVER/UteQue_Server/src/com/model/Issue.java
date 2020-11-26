package com.model;

import java.io.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issue")
public class Issue implements Serializable{
	
	private static final long serialVersionUID = 5158752509920824080L;

	@Id
	@Column(name="issueID")
	private String issueID;

	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String status;
	
	@Column(name="studentID")
	private String studentID;
	
	@Column(name="message")
	private String message;
	
	@Column(name="serviceID")
	private int serviceID;
	
	@Column(name="issuedAt")
	private Date issuedAt;
	
	@Column(name="scheduledDateTime")
	private Date scheduledDateTime;
	
	@Column(name="repID")
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
