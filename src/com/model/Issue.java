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
	private String summary;
	private Date issuedAt;
	private Date scheduledDateTime;
	private String repId;
	
	public Issue() {
		this.issueId = "";
		this.type = "";
		this.status = "";
		this.studentId = "";
		this.message = "";
		this.summary = "";
		this.issuedAt = null;
		this.scheduledDateTime = null;
		this.repId = "";	
	}
	
	public Issue(String issueId, String type, String status, 
			String studentId, String message, String summary,
			Date issuedAt, Date scheduledDateTime, String repId) {
		
		this.issueId = issueId;
		this.type = type;
		this.status = status;
		this.studentId = studentId;
		this.message = message;
		this.summary = summary;
		this.issuedAt = issuedAt;
		this.scheduledDateTime = scheduledDateTime;
		this.repId = repId;	
		
	}

	public String getIssueId() {
		return issueId;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getMessage() {
		return message;
	}

	public String getSummary() {
		return summary;
	}

	public Date getIssuedAt() {
		return issuedAt;
	}

	public Date getScheduledDateTime() {
		return scheduledDateTime;
	}

	public String getRepId() {
		return repId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setIssuedAt(Date issuedAt) {
		this.issuedAt = issuedAt;
	}

	public void setScheduledDateTime(Date scheduledDateTime) {
		this.scheduledDateTime = scheduledDateTime;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", type=" + type + ", status=" + status + ", studentId=" + studentId
				+ ", message=" + message + ", summary=" + summary + ", issuedAt=" + issuedAt + ", scheduledDateTime="
				+ scheduledDateTime + ", repId=" + repId + "]";
	}
	
	
	

}
