package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccountTransaction {

	@Id @GeneratedValue
	private int sequenceID;
	
	private String date;
	private float amount;
	private int debitCredit;
	private String description;
	private int billReference;
	
	public int getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getDebitCredit() {
		return debitCredit;
	}
	public void setDebitCredit(int debitCredit) {
		this.debitCredit = debitCredit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBillReference() {
		return billReference;
	}
	public void setBillReference(int billReference) {
		this.billReference = billReference;
	}
	
	
}
