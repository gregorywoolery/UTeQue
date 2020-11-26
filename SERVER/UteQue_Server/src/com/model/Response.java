package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="response")
public class Response implements Serializable{

	private static final long serialVersionUID = 931876114821350932L;

	@Id
	@Column(name="responseID")
	private String responseID;
	
	@Column(name="issueID")
	private String issueID;
	
	@Column(name="userID")
	private String userID;
	
	@Column(name="message")
	private String message;
	
	@Column(name="responseAt")
	private Date responseAt;
	
	@Column(name="isAnswer")
	private boolean isAnswer;
	
	
	public Response() {
		this.responseID = "";
		this.issueID = "";
		this.userID = "";
		this.message = "";		
		this.responseAt = null;
		this.isAnswer = false;		
	}

	public Response(String responseID, String issueID, String userID,
			String message, Date responseAt, boolean isAnswer) {

		this.responseID = responseID;
		this.issueID = issueID;
		this.userID = userID;
		this.message = message;		
		this.responseAt = responseAt;
		this.isAnswer = isAnswer;
	}
	
	
	public String getResponseID() {
		return responseID;
	}
	
	public String getIssueID() {
		return issueID;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Date getResponseAt() {
		return responseAt;
	}
	
	public boolean isAnswer() {
		return isAnswer;
	}
	
	public void setResponseID(String responseID) {
		this.responseID = responseID;
	}
	
	public void setIssueID(String issueID) {
		this.issueID = issueID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setResponseAt(Date responseAt) {
		this.responseAt = responseAt;
	}
	
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	
	@Override
	public String toString() {
		return "Response [responseID=" + responseID + ", issueID=" + issueID + ", userID=" + userID + ", message="
				+ message + ", responseAt=" + responseAt + ", isAnswer=" + isAnswer + "]";
	}	
}
