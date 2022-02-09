package com.seleniumexpress.lc.api;

import java.math.BigDecimal;

public class Amount {

	
	private BigDecimal billAmount;
	private String localDefinition;
	
	public BigDecimal getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}
	public String getLocalDefinition() {
		return localDefinition;
	}
	public void setLocalDefinition(String localDefinition) {
		this.localDefinition = localDefinition;
	}
	
	
	@Override
	public String toString() {
		return getLocalDefinition() + getBillAmount();
	}


}
