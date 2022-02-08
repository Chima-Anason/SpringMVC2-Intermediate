package com.seleniumexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard>{

	@Override
	public String print(CreditCard creditCard, Locale locale) {
		
		
		System.out.println("Inside the print method of CreditCardFormatter");
		
		
		return creditCard.getFirstFourDigits() + "-" + creditCard.getSecondFourDigits() + "-" + creditCard.getThirdFourDigits() + "-" + creditCard.getFourtFourDigits();
	}

	@Override
	public CreditCard parse(String completeCreditCardNumber, Locale locale) throws ParseException {
		
		System.out.println("Inside the parse method of CreditCardFormatter");
		
		
		CreditCard creditCard = new CreditCard();
		
		
		//split the credit card number
		String[] creditCardArray = completeCreditCardNumber.split("-");
		
		
		int index = completeCreditCardNumber.indexOf("-");
		
		//if the user insert number without '-', the formatter helps us cut the number
		if (index == -1) {
			
			//if the length of string is not equal 16
			if (completeCreditCardNumber.length() == 16) {
				
				creditCard.setFirstFourDigits(Integer.parseInt(completeCreditCardNumber.substring(0, 4)));
				creditCard.setSecondFourDigits(Integer.parseInt(completeCreditCardNumber.substring(4, 8)));
				creditCard.setThirdFourDigits(Integer.parseInt(completeCreditCardNumber.substring(8, 12)));
				creditCard.setFourtFourDigits(Integer.parseInt(completeCreditCardNumber.substring(12, 16)));
				
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
		
		
		
		
		return creditCard;
	}

}
