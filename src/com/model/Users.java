package com.model;

import java.io.Serializable;

public class Users implements Serializable{
	//Attributes
	protected static final long serialVersionUID = 1L;
	protected String Type;
	protected String ID;
	protected String Password ;
	protected String Fname ;
	protected String Lname ;
	protected String Email;
	protected Date DateOfBirth ;
	protected String Phone;

	//Default Constructor
	public Users() {
		Type = "";
		ID= "";
		Password = "";
		Fname = "";
		Lname = "";
		Email= "";
		DateOfBirth = new Date(0,0,0);
		Phone = "";
	}
	//Primary Constructor
	public Users(String type, String id, String pw, String fname, String lname, String email, Date dob, String phone) {
		Type = type;
		ID= id;
		Password = pw;
		Fname = fname;
		Lname = lname;
		Email= email;
		DateOfBirth = dob;
		Phone = phone;
	}
	//Copy Constructor
	public Users(Users Obj) {
		Type = Obj.Type;
		ID= Obj.ID;
		Password = Obj.Password;
		Fname = Obj.Fname;
		Lname = Obj.Lname;
		Email= Obj.Email;
		DateOfBirth = Obj.DateOfBirth;
		Phone = Obj.Phone;
	}
	
	//Setters and Getters
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Users [Type=" + Type + ", ID=" + ID + ", Password=" + Password + ", Fname=" + Fname + ", Lname=" + Lname
				+ ", Email=" + Email + ", DateOfBirth=" + DateOfBirth + ", Phone=" + Phone + "]";
	}

}
