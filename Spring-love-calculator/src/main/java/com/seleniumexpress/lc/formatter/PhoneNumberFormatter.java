package com.seleniumexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		
		
		System.out.println("Inside the parse method of the PhoneNuberFormatter");
		
		//logic here
		//First: Split the String received from the user
		String[] phoneNumberArray = completePhoneNumber.split("-");
		
		
		
		//second: Extract the countryCode and set it to the Phone class countryCode property
		Phone phone = new Phone();
		
		phone.setCountryCode(phoneNumberArray[0]);
		phone.setUserNumber(phoneNumberArray[1]);;
		
		
		
		return phone;
	}

}
