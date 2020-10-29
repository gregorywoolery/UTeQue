package com.model;

import java.io.Serializable;
public class Date implements Serializable{
	private static final long serialVersionUID = 1L;
	private int Day;
	private int Month;
	private int Year;
	
	//Default Constructor 
	public Date() {
		Day = 1;
		Month = 1;
		Year = 1900;
	}
	//Primary Constructor
	public Date(int d, int m, int y) {
			this.Day = d;
			this.Month = m;
			this.Year = y;
	}
	//Copy Constructor
	public Date(Date date) {
		setDay(date.getDay());
		setMonth(date.getMonth());
		setYear(date.getYear());
	}
	//Setters and Getters
	public void setDay(int d) {
		Day = d;
	}
	public int getDay() {
		return Day;
	}
	
	public void setMonth(int m) {
		Month = m;
	}
	public int getMonth() {
		return Month;
	}
	
	public void setYear(int y) {
		Year = y;
	}
	public int getYear() {
		return Year;
	}
	@Override
	public String toString() {
		return "Date [Day=" + Day + ", Month=" + Month + ", Year=" + Year + "]";
	}

	
}
