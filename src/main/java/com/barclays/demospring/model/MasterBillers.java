package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MasterBillers {
	
	@Id
	private String billerCode;
	private String name;
	
	public String getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
