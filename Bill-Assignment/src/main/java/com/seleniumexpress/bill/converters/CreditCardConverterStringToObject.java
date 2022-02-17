package com.seleniumexpress.bill.converters;

import org.springframework.core.convert.converter.Converter;

import com.seleniumexpress.bill.api.CreditCard;

public class CreditCardConverterStringToObject implements Converter<String, CreditCard>{

	@Override
	public CreditCard convert(String source) {
		
CreditCard creditCard = new CreditCard();
		
		
		//split the credit card number
		String[] creditCardArray = source.split("-");
		
		
		int index = source.indexOf("-");
		
		//if the user insert number without '-', the formatter helps us cut the number
		if (index == -1) {
			
			//if the length of string is not equal 16
			if (source.length() == 16) {
				
				creditCard.setFirstFourDigits(Integer.parseInt(source.substring(0, 4)));
				creditCard.setSecondFourDigits(Integer.parseInt(source.substring(4, 8)));
				creditCard.setThirdFourDigits(Integer.parseInt(source.substring(8, 12)));
				creditCard.setFourtFourDigits(Integer.parseInt(source.substring(12, 16)));
				
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
