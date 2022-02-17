package com.seleniumexpress.bill.converters;

import org.springframework.core.convert.converter.Converter;

import com.seleniumexpress.bill.api.CreditCard;

public class CreditCardConverterObjToString implements Converter<CreditCard, String> {

	@Override
	public String convert(CreditCard source) {
		
		
		
		return "sample" + source;
	}

}
