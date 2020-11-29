package com.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="studentservicesagent")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "agentID"))
})
public class StudentServicesAgent extends User implements Serializable{

	private static final long serialVersionUID = -1896512115996031719L;
	
	@Column(name="canRespond")
	private boolean canRespond;
	
	public boolean getCanRespond() {
		return canRespond;
	}
	
	public void setCanRespond(boolean canRespond) {
		this.canRespond = canRespond;
	}

}
