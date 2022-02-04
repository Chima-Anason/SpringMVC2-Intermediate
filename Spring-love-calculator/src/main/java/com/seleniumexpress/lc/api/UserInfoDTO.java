package com.seleniumexpress.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Spring MVC Form validation 
public class UserInfoDTO {
	
	@NotBlank(message =" * User name can't be blank")
	@Size(min = 3,max = 15,message = " * Your name should have char between 3-15")
	private String userName;
	
	@NotBlank(message =" * Crush name can't be blank")
	@Size(min = 3,max = 15,message = " * Crush name should have char between 3-15")
	private String crushName;
	
	@AssertTrue(message = "You have to agree to use our application")
	private boolean termAndCondition;
	
	
	
	
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
	
	
	public boolean isTermAndCondition() {
		return termAndCondition;
	}
	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}
	
	
	
	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + "]";
	}

	
}
