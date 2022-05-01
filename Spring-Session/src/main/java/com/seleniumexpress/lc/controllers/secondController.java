package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class secondController {
	
	@RequestMapping("/normalMethod")
	public String handlermethod1(@SessionAttribute("firstName") String firstName,Model model) {
		
		//String firstname = (String)model.getAttribute("firstName");
		 String newFirstName = "Mr " + firstName;
		 model.addAttribute("firstName", newFirstName);
		System.out.println("inside new controller method, Printing firstName"+newFirstName);
		
		return "index";
	}

}
