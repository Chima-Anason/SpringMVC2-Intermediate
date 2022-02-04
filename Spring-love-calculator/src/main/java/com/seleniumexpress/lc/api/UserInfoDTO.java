package com.seleniumexpress.lc.api;


//NB: Text box name must be = property name 
public class UserInfoDTO {
	
	//Two-Way-Data-Binding(To Read and Write)
	private String userName;
	private String crushName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + "]";
	}

	
}
