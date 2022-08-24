package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bill {
	@Id @GeneratedValue
	
	private int sequenceID;
	
	private String bCode;
	private String consumerNumber;
	
	private float amount;
	private String dueDate;
	private String status;
//	paid, pending, failed
	
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
	public String getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(String consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Bill [sequenceID=" + sequenceID + ", bCode=" + bCode + ", consumerNumber=" + consumerNumber
				+ ", amount=" + amount + ", dueDate=" + dueDate + ", status=" + status + "]";
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
