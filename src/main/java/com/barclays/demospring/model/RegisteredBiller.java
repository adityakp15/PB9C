package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RegisteredBiller {

	@Override
	public String toString() {
		return "sequenceID=" + sequenceID + ", bCode=" + bCode + ", cNumber=" + cNumber + ", aNumber="
				+ aNumber + ", aP=" + aP + ", date=" + date + ", aPLimit=" + aPLimit;
	}
	
	public int togetseqid() {
		return sequenceID;
	}
	public String togetDate() {
		return date;
	}
	@Id @GeneratedValue
	private int sequenceID;
	
	private String bCode;
	private String cNumber;
	private int aNumber;
	private boolean aP;
	private int aPLimit;
	private String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
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
	public String getcNumber() {
		return cNumber;
	}
	public void setcNumber(String cNumber) {
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
