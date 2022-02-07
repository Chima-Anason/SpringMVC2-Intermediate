package com.seleniumexpress.lc.api;

public class CommunicationDTO {
	
	private String email = "test@test.com";
	
	//Creating a Phone number consisting of {countryCode + userNumber}
	private Phone phone;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
