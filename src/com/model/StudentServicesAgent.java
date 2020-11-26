package com.model;

import java.io.Serializable;

public class StudentServicesAgent extends User implements Serializable{

	private static final long serialVersionUID = -1896512115996031719L;

	private boolean canRespond;
	
	public boolean getCanRespond() {
		return canRespond;
	}
	
	public void setCanRespond(boolean canRespond) {
		this.canRespond = canRespond;
	}

}
