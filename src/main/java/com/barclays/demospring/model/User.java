package com.barclays.demospring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	
	@Id
	private int loginID;
	
	private String password;
	private int roleID;
	
	@Id	@GeneratedValue
	private int sequenceID;
	
//	public User(int lID, String pass, int rID) {
//		
//		loginID = lID;
//		password = pass;
//		roleID = rID;
//	}
	

	public int getLoginID() {
		return loginID;
	}
	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleID() {
		return roleID;
	}
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	public int getSequenceID() {
		return sequenceID;
	}
	public void setSequenceID(int sequenceID) {
		this.sequenceID = sequenceID;
	}
	
	@Override
	public String toString() {
		return "User [loginID=" + loginID + ", roleID=" + roleID + ", sequenceID=" + sequenceID + "]";
	}
	
}
