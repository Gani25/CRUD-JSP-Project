package com.model;

import java.sql.Timestamp;

public class Student {

	private int sId;
	private String sName;
	private String sEmail;
	private String sPhone;
	private String sGender;
	private Timestamp accCreated;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsEmail() {
		return sEmail;
	}
	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}
	public String getsPhone() {
		return sPhone;
	}
	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}
	public String getsGender() {
		return sGender;
	}
	public void setsGender(String sGender) {
		this.sGender = sGender;
	}
	public Timestamp getAccCreated() {
		return accCreated;
	}
	public void setAccCreated(Timestamp accCreated) {
		this.accCreated = accCreated;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sEmail=" + sEmail + ", sPhone=" + sPhone + ", sGender="
				+ sGender + ", accCreated=" + accCreated + "]";
	}
	
	
	
	
	
}
