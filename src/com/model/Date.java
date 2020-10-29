package com.model;

import java.io.Serializable;
public class Date implements Serializable{
	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;
	
	//Default Constructor 
	public Date() {
		day = 1;
		month = 1;
		year = 1900;
	}
	//Primary Constructor
	public Date(int day, int month, int year) {
			this.day = day;
			this.month = month;
			this.year = year;
	}
	//Copy Constructor
	public Date(Date date) {
		setDay(date.getDay());
		setMonth(date.getMonth());
		setYear(date.getYear());
	}
	//Setters and Getters
	public void setDay(int day) {
		this.day = day;
	}
	public int getDay() {
		return day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	public int getMonth() {
		return month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		return "Date [Day=" + day + ", Month=" + month + ", Year=" + year + "]";
	}

	
}
