package com.model;

import java.io.*;
import java.io.Serializable;

public class Users implements Serializable{
	//Attributes
	protected static final long serialVersionUID = 1L;
	protected String type;
	protected String id;
	protected String password ;
	protected String fname ;
	protected String lname ;
	protected String gender;
	protected String email;
	protected Date dob ;
	protected String phone;

	//Default Constructor
	public Users() {
		this.type = "";
		this.id= "";
		this.password = "";
		this.fname = "";
		this.lname = "";
		this.gender = "";
		this.email= "";
		this.dob = new Date(0,0,0);
		this.phone = "";
	}
	//Primary Constructor
	public Users(String type, String id, String password, String fname, String lname, String gender,String email, Date dob, String phone) {
		this.type = type;
		this.id = id;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
	}
	//Copy Constructor
	public Users(Users Obj) {
		this.type = Obj.type;
		this.id = Obj.id;
		this.password = Obj.password;
		this.fname = Obj.fname;
		this.lname = Obj.lname;
		this.gender = Obj.gender;
		this.email= Obj.email;
		this.dob = Obj.dob;
		this.phone = Obj.phone;
	}
	
	//Setters and Getters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Users [Type=" + type + ", ID=" + id + ", Password=" + password + ", First name=" + fname + ", Last name=" + lname
				+ ", Gender=" + gender + ", Email=" + email + ", DOB=" + dob + ", Phone=" + phone + "]";
	}
	public void display() {
		System.out.println(toString());
		
	}


}
