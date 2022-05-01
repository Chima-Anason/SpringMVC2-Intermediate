package com.seleniumexpress.lc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class secondController {
	
	@RequestMapping("/normalMethod")
	public String handlermethod1(Model model,HttpSession session) {
		
		//String firstname = (String)model.getAttribute("firstName");
		/*
		 * String newFirstName = "Mr " + firstName; model.addAttribute("firstName",
		 * newFirstName);
		 * System.out.println("inside new controller method, Printing firstName"
		 * +newFirstName);
		 */
		
		//retreiving the session attribute from http session
		String address = (String)session.getAttribute("address");
		String newAddress = address + "  This is my home";
		model.addAttribute("address", newAddress);
		
		return "index";
	}

}
