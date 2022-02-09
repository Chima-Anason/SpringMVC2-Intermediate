package com.seleniumexpress.bill.api;

public class CreditCard {
	
	private Integer firstFourDigits;
	private Integer secondFourDigits;
	private Integer thirdFourDigits;
	private Integer fourtFourDigits;
	
	
	public Integer getFirstFourDigits() {
		return firstFourDigits;
	}
	public void setFirstFourDigits(Integer firstFourDigits) {
		this.firstFourDigits = firstFourDigits;
	}
	public Integer getSecondFourDigits() {
		return secondFourDigits;
	}
	public void setSecondFourDigits(Integer secondFourDigits) {
		this.secondFourDigits = secondFourDigits;
	}
	public Integer getThirdFourDigits() {
		return thirdFourDigits;
	}
	public void setThirdFourDigits(Integer thirdFourDigits) {
		this.thirdFourDigits = thirdFourDigits;
	}
	public Integer getFourtFourDigits() {
		return fourtFourDigits;
	}
	public void setFourtFourDigits(Integer fourtFourDigits) {
		this.fourtFourDigits = fourtFourDigits;
	}
	
	
	@Override
	public String toString() {
		return getFirstFourDigits() + "-" + getSecondFourDigits() + "-" + getThirdFourDigits() + "-" + getFourtFourDigits();
	}
	
	

}

