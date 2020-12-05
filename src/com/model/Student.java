package com.model;

import java.io.Serializable;
import java.util.Date;

public class Student extends User implements Serializable{

	private static final long serialVersionUID = 3935091312256888891L;

	private Date dob ;

	public Student() {
		super();
	}
	
	public Student(String studentID, String password, 
			String fname, String lname, String gender,
			String email, String phone, Date dob) 
	{
		super(studentID, password, fname, lname, 
				gender,	email, phone);
		
		this.dob = dob;
	}
	
	public Date getDOB() {
		return dob;
	}
	
	public void setDOB(Date dob) {
		this.dob = dob;
	}
}
