package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegisteredBiller {

	@GeneratedValue
	private int sequenceID;
	
	@Id
	private String bCode;
	private int cNumber;
	private int aNumber;
	private boolean aP;
	private int aPLimit;
	public int getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}
	public String getbCode() {
		return bCode;
	}
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public int getcNumber() {
		return cNumber;
	}
	public void setcNumber(int cNumber) {
		this.cNumber = cNumber;
	}
	public int getaNumber() {
		return aNumber;
	}
	public void setaNumber(int aNumber) {
		this.aNumber = aNumber;
	}
	public boolean isaP() {
		return aP;
	}
	public void setaP(boolean aP) {
		this.aP = aP;
	}
	public int getaPLimit() {
		return aPLimit;
	}
	public void setaPLimit(int aPLimit) {
		this.aPLimit = aPLimit;
	}
	
	
	
	
	
}
