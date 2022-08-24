package com.barclays.demospring.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RequestedBill {
	@Id @GeneratedValue
	private int rbIndex;
	
	private String bCode;
	private String Cnumber;
	private float Amount;
	private String DueDate;
	private String Status; 
//	- approved, rejected, pending
	
	public String getbCode() {
		return bCode;
	}
	
	public void setbCode(String bCode) {
		this.bCode = bCode;
	}
	public String getCnumber() {
		return Cnumber;
	}
	public void setCnumber(String cnumber) {
		Cnumber = cnumber;
	}
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}

	public int getRbIndex() {
		return rbIndex;
	}

	public void setRbIndex(int rbIndex) {
		this.rbIndex = rbIndex;
	}

	@Override
	public String toString() {
		return "RequestedBills [rbIndex=" + rbIndex + ", bCode=" + bCode + ", Cnumber=" + Cnumber + ", Amount="
				+ Amount + ", DueDate=" + DueDate + ", Status=" + Status + "]";
	}
	
	
}
