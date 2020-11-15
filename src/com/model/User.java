package com.model;

import java.io.Serializable;

public class User implements Serializable{
	//Attributes
	protected static final long serialVersionUID = 1L;
	protected String id;
	protected String password ;
	protected String fname ;
	protected String lname ;
	protected String gender;
	protected String email;
	protected String phone;

	//Default Constructor
	public User() {
		this.id= "";
		this.password = "";
		this.fname = "";
		this.lname = "";
		this.gender = "";
		this.email= "";
		this.phone = "";
	}
	
	//Primary Constructor
	public User(String id, String password, String fname, 
			String lname, String gender, String email, 
			String phone) 
	{
		this.id = id;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	
	//Copy Constructor
	public User(User user) {
		this.id = user.id;
		this.password = user.password;
		this.fname = user.fname;
		this.lname = user.lname;
		this.gender = user.gender;
		this.email= user.email;
		this.phone = user.phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [ID=" + id + ", Password=" + password + ", First name=" + fname + ", Last name=" + lname
				+ ", Gender=" + gender + ", Email=" + email + ", Phone=" + phone + "]";
	}

}
