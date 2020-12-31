package com.model;

import java.io.Serializable;
import java.util.Date;

public class Response implements Serializable{

	private static final long serialVersionUID = 931876114821350932L;

	private String responseID;
	private String issueID;
	private String userID;
	private String message;
	private Date responseAt;
	private boolean isAnswer;
	private String comment;
	
	
	public Response() {
		this.responseID = null;
		this.issueID = null;
		this.userID = null;
		this.message = null;		
		this.responseAt = null;
		this.isAnswer = false;
		this.comment = null;
	}

	public Response(String responseID, String issueID, String userID,
			String message, Date responseAt, boolean isAnswer, String comment) {

		this.responseID = responseID;
		this.issueID = issueID;
		this.userID = userID;
		this.message = message;		
		this.responseAt = responseAt;
		this.isAnswer = isAnswer;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Response [responseID=" + responseID + ", issueID=" + issueID + ", userID=" + userID + ", message="
				+ message + ", responseAt=" + responseAt + ", isAnswer=" + isAnswer + ", comment=" + comment + "]";
	}
}
