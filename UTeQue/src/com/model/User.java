package com.model;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 8642887600908555187L;

	protected String id;
	protected String password ;
	protected String firstname ;
	protected String lastname ;
	protected String gender;
	protected String email;
	protected String phone;
	private String type;

	//Default Constructor
	public User() {
		this.id= "";
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.gender = "";
		this.email= "";
		this.phone = "";
		this.type = "";
	}
	
	//Primary Constructor
	public User(String id, String password, String fname, 
			String lname, String gender, String email, 
			String phone) 
	{
		this.id = id;
		this.password = password;
		this.firstname = fname;
		this.lastname = lname;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	
	public User(String username, String type) {
		this.id = username;
		this.type = type;
	}
	
	public User(String username, char[] password, String type) {
		this.id = username;
		this.password = String.valueOf(password);
		this.type = type;
	}
	
	//Copy Constructor
	public User(User user) {
		this.id = user.id;
		this.password = user.password;
		this.firstname = user.firstname;
		this.lastname = user.lastname;
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String fname) {
		firstname = fname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lname) {
		lastname = lname;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", type=" + type + "]";
	}



}
