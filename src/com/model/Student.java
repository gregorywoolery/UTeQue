package com.model;

import java.io.Serializable;
import java.util.Date;

public class Student extends User implements Serializable{
	//Attributes
	private static final long serialVersionUID = 1L;
	private Date dob ;
	
	
	public Date getDOB() {
		return dob;
	}
	
	public void setDOB(Date dob) {
		this.dob = dob;
	}
}
