package com.seleniumexpress.bill.propertyEditor;

import java.beans.PropertyEditorSupport;

import com.seleniumexpress.bill.api.CreditCard;

public class CreditCardEditor extends PropertyEditorSupport {
	
	
	@Override
	public String getAsText() {
		
		CreditCard creditCard = (CreditCard)getValue();
		
		return "sample :" +creditCard;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		CreditCard creditCard = new CreditCard();
		
		
		//split the credit card number
		String[] creditCardArray = text.split("-");
		
		
		int index = text.indexOf("-");
		
		//if the user insert number without '-', the formatter helps us cut the number
		if (index == -1) {
			
			//if the length of string is not equal 16
			if (text.length() == 16) {
				
				creditCard.setFirstFourDigits(Integer.parseInt(text.substring(0, 4)));
				creditCard.setSecondFourDigits(Integer.parseInt(text.substring(4, 8)));
				creditCard.setThirdFourDigits(Integer.parseInt(text.substring(8, 12)));
				creditCard.setFourtFourDigits(Integer.parseInt(text.substring(12, 16)));
				
			} else {

				
				System.out.println("The inputted value is not 16");
				creditCard.setFirstFourDigits(Integer.parseInt("0000"));
				creditCard.setSecondFourDigits(Integer.parseInt("0000"));
				creditCard.setThirdFourDigits(Integer.parseInt("0000"));
				creditCard.setFourtFourDigits(Integer.parseInt("0000"));
			}
			
		} else {
			
			//if the user insert number with '-' 
			//Extract & set it to each properties of the CreditCard object
			
			creditCard.setFirstFourDigits(Integer.parseInt(creditCardArray[0]));
			creditCard.setSecondFourDigits(Integer.parseInt(creditCardArray[1]));
			creditCard.setThirdFourDigits(Integer.parseInt(creditCardArray[2]));
			creditCard.setFourtFourDigits(Integer.parseInt(creditCardArray[3]));

		}
		
		
		
		
		setValue(creditCard);

	}

}
