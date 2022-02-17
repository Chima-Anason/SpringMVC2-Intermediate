package com.seleniumexpress.bill.controllers;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.text.NumberFormatter;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.bill.api.Bill;
import com.seleniumexpress.bill.api.CreditCard;
import com.seleniumexpress.bill.formatter.CreditCardFormatter;
import com.seleniumexpress.bill.formatter.CurrencyFormatter;
import com.seleniumexpress.bill.propertyEditor.CreditCardEditor;


@Controller
public class BillController {
	
	@RequestMapping("/")
	public String showBillFormPage(@ModelAttribute("billDTO") Bill bill) {
		
		System.out.println("Inside the showBillFormPage method");
		
		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigits(1234);
		creditCard.setSecondFourDigits(5454);
		creditCard.setThirdFourDigits(3322);
		creditCard.setFourtFourDigits(8284);
		
		bill.setCreditCard(creditCard);
		
		return "bill-form-page";
	}
	
	@RequestMapping("/bill-success")
	public String processBill(@ModelAttribute("billDTO") Bill bill) {
		
		System.out.println("Inside the processBill method");

		
		return "bill-success-page";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		//Register a custom Editor for Date field
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", editor);
		
		
		//Register a custom Editor for Amount field
//		NumberFormat numberFormat = new DecimalFormat("##,###.00");
//		CustomNumberEditor numberEditor = new CustomNumberEditor(BigDecimal.class, numberFormat, true);
//		binder.registerCustomEditor(BigDecimal.class, "billAmount",numberEditor);
		
		
		//Another way to register our formatter
//		binder.addCustomFormatter(new CreditCardFormatter());
		binder.addCustomFormatter(new CurrencyFormatter());
		
		//register a custom Editor for Credit card Editor = also works like Credit card formatter
//		CreditCardEditor creditCardEditor = new CreditCardEditor();
//		binder.registerCustomEditor(CreditCard.class, "creditCard", creditCardEditor);
		
		
	}

}

