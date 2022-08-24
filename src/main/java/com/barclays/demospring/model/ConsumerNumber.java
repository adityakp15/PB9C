package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConsumerNumber {

	@Id @GeneratedValue
	private int index;
	private String consumerNumber;
	private int loginID;
	
	
	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	public String getConsumerNumber() {
		return consumerNumber;
	}



	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}



	public int getLoginID() {
		return loginID;
	}



	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}



	@Override
	public String toString() {
		return "ConsumerNumber [index=" + index + ", consumerNumber=" + consumerNumber + ", loginID=" + loginID + "]";
	}
	
	
}
