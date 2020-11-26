package com.model;

import java.io.Serializable;

public class StudentServicesRep extends User implements Serializable{

	private static final long serialVersionUID = 7626842462614503143L;

	private boolean canRespond;
	
	public boolean getCanRespond() {
		return canRespond;
	}
	
	public void setCanRespond(boolean canRespond) {
		this.canRespond = canRespond;
	}
}
