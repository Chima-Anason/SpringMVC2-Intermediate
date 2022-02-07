package com.seleniumexpress.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside the print method of the PhoneNuberFormatter class");
		//logic to convert phone object to string
		
		
		//concatinate the countryCode and the PhoneNumber and return it
		
		
		return phone.getCountryCode() + "-" + phone.getUserNumber();
	}

	
	
	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		
		
		System.out.println("Inside the parse method of the PhoneNuberFormatter class");
		
		//logic to convert string to phone object
		//First: Split the String received from the user
		String[] phoneNumberArray = completePhoneNumber.split("-");
		
		
		
		//second: Extract the countryCode and phoneNumber then set it to the Phone class countryCode and phoneNumber property
		Phone phone = new Phone();
		
		phone.setCountryCode(phoneNumberArray[0]);
		phone.setUserNumber(phoneNumberArray[1]);;
		
		
		
		return phone;
	}

}
