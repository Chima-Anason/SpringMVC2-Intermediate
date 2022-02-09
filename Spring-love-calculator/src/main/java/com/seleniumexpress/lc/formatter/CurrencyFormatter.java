package com.seleniumexpress.lc.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.seleniumexpress.lc.api.Amount;

public class CurrencyFormatter implements Formatter<Amount> {

	@Override
	public String print(Amount object, Locale locale) {

		System.out.println("Inside the print method of CurrencyFormatter");
		
		
		return null;
	}

	@Override
	public Amount parse(String completeAmount, Locale locale) throws ParseException {
		
		System.out.println("Inside the parse method of CurrencyFormatter");
		
	
		//String[] amountArray = {};
		String amountArray[] = new String[2];
		
		int index = completeAmount.indexOf(' ');
		
		if (index == -1 || completeAmount.startsWith(" ")) {
			
			StringBuilder digit = new StringBuilder();
			StringBuilder letters = new StringBuilder();
			 for (char c : completeAmount.toCharArray()) {
			     if (Character.isDigit(c) || c == '.' || c == ',') { 
			    	 digit.append(c);
			     } else {
			    	 letters.append(c);
			    	 
			     }
			 }
			 
			 amountArray[0] = digit.toString();
			 amountArray[1] = letters.toString();
			
		}else {
			//split the Amount string
			amountArray = completeAmount.split(" ");
		}

		
		BigDecimal amountArrayAtIndex0 = new BigDecimal(amountArray[0]);
		String amountArrayAtIndex1 = amountArray[1];
		
		Amount amount = new Amount();
		

		//Check which curreny and then convert the splitted array[0] -> currency value
		if (amountArrayAtIndex1.equalsIgnoreCase("USD")) {
			
			String format = NumberFormat.getCurrencyInstance(locale.US).format(amountArrayAtIndex0);
			
			injectSplittedValue(format,amount);
			
			
		}else if (amountArrayAtIndex1.equalsIgnoreCase("EURO")) {

			String format = NumberFormat.getCurrencyInstance(locale.GERMAN).format(amountArrayAtIndex0);
			
			injectSplittedValue(format,amount);
			
		}else if (amountArrayAtIndex1.equalsIgnoreCase("CN")) {

			String format = NumberFormat.getCurrencyInstance(locale.CHINA).format(amountArrayAtIndex0);
			
			injectSplittedValue(format,amount);
			
		}else if (amountArrayAtIndex1.equalsIgnoreCase("POL")) {
			
			String format = NumberFormat.getCurrencyInstance(locale.FRANCE).format(amountArrayAtIndex0);
			
			injectSplittedValue(format,amount);
		}else {

			String format = NumberFormat.getCurrencyInstance(locale.US).format(amountArrayAtIndex0);
			
			injectSplittedValue(format,amount);
		}

		
		return amount;
	}
	
	
	
	public Amount injectSplittedValue(String format, Amount amount) {
		
		//split converted result and set to properties in Amount
		//Amount amount = new Amount();
		
		//splitting the converted result
		StringBuilder value = new StringBuilder();
		 for (char c : format.toCharArray()) {
		     if (Character.isDigit(c) || c == '.' || c == ',') { 
		    	value.append(c);
		     } else {
		    	 amount.setLocalDefinition(Character.toString(c));
		     }
		 }
		 
		 BigDecimal convertToBigDecimal = new BigDecimal(value.toString());
         amount.setBillAmount(convertToBigDecimal);
		
		return amount;
	}

}


