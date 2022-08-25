package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ConsumerNumber {

	@Id @GeneratedValue
	private int cid;
	
	private String cno;
	
	private int loginID;
	
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	public int getIndex() {
		return cid;
	}


	public void setIndex(int index) {
		this.cid = index;
	}


	public int getLoginID() {
		return loginID;
	}



	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}



	@Override
	public String toString() {
		return "ConsumerNumber [index=" +cid + ", consumerNumber=" + cno + ", loginID=" + loginID + "]";
	}
	
	
}
