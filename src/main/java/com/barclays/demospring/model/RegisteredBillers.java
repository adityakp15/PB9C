package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegisteredBillers {

	@GeneratedValue
	private int sequenceID;
	
	@Id
	private String billerCode;
	private int consumerNumber;
	private int accountNumber;
	private boolean autoPay;
	private int autoPayLimit;
	
	public int getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}
	public String getBillerCode() {
		return billerCode;
	}
	public void setBillerCode(String billerCode) {
		this.billerCode = billerCode;
	}
	public int getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public boolean isAutoPay() {
		return autoPay;
	}
	public void setAutoPay(boolean autoPay) {
		this.autoPay = autoPay;
	}
	public int getAutoPayLimit() {
		return autoPayLimit;
	}
	public void setAutoPayLimit(int autoPayLimit) {
		this.autoPayLimit = autoPayLimit;
	}
	
	
	
}
