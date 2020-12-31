package com.model;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = -5650432858536164271L;

	private String senderID;
	private String receiverID;
	private String message;
	
	public Message() {
		senderID = null;
		receiverID = null;
		message = null;
	}

	public Message(String senderID, String receiverID, String message) {
		this.senderID = senderID;
		this.receiverID = receiverID;
		this.message = message;
	}
	
	public String getSenderID() {
		return senderID;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public String getMessage() {
		return message;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ChatMessage [senderID=" + senderID + ", receiverID=" + receiverID + ", message=" + message + "]";
	}
	
	
}
