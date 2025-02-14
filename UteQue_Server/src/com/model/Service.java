package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="service")
public class Service implements Serializable{
	private static final long serialVersionUID = 4348842477932781763L;

	@Id
	@Column(name="serviceID")
	private int serviceID;

	@Column(name="type")
	private String type;
	
	
	public Service() {
		this.serviceID = -1;
		this.type = "";
	}
	
	public Service(int serviceID, String type) {
		this.serviceID = serviceID;
		this.type = type;
	}
	
	public Service(String type) {
		this.type = type;
	}	
	
	public Service(Service service) {
		setServiceID(service.getServiceID());
		setType(service.getType());
	}
	
	public int getServiceID() {
		return serviceID;
	}
	
	public String getType() {
		return type;
	}
	
	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Service [serviceID=" + serviceID + ", type=" + type + "]";
	}
}
