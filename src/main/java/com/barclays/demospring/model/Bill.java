package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bill {

	@Id
	private String bCode;
	
	@GeneratedValue
	private int sequenceID;
	
	
	
	private int consumerNumber;
	
	private int amount;
	private String dueDate;
	private String status;
	
	public int getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}
	public String getBillerCode() {
		return bCode;
	}
	public void setBillerCode(String billerCode) {
		this.bCode = billerCode;
	}
	public int getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
