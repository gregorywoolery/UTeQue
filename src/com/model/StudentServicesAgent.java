package com.model;

import java.io.Serializable;

public class StudentServicesAgent extends User implements Serializable{
	//Attributes
	private static final long serialVersionUID = 1L;
	
	private boolean canRespond;
	
	public boolean getCanRespond() {
		return canRespond;
	}
	
	public void setCanRespond(boolean canRespond) {
		this.canRespond = canRespond;
	}

}
