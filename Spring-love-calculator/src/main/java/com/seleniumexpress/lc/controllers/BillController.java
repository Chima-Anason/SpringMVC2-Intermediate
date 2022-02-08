package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.Bill;
import com.seleniumexpress.lc.api.CreditCard;

@Controller
public class BillController {
	
	@RequestMapping("/bill")
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

}
