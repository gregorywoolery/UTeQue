package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="student")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "studentID"))
})
public class Student extends User implements Serializable{

	private static final long serialVersionUID = 3935091312256888891L;
	
	@Column(name="dob")
	private Date dob ;
	
	public Student() {
		super();
		dob = null;
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
