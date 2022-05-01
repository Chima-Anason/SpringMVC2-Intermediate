package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"firstName","lastName"})
public class firstController {
	
	@RequestMapping("/first")
	public String handlermethod1(Model model) {
		
		model.addAttribute("firstName", "Chima");
		model.addAttribute("lastName", "John");
		
		model.addAttribute("next", "/second");
		
		return "index";
	}
	
	
	@RequestMapping("/second")
	public String handlermethod2(Model model1,SessionStatus status) {
		
		String firstname = (String)model1.getAttribute("firstName");
		System.out.println(firstname);
		
		String lastname = (String)model1.getAttribute("lastName");
		System.out.println(lastname);
		
		//model1.addAttribute("firstName", firstname);
		//model1.addAttribute("lastName", lastname);
		
		
		//removing the session attributes from the session scope
		//status.setComplete();
		
		model1.addAttribute("next", "/third");
		
		return "index";
	}
	
	
	@RequestMapping("/third")
	public String handlermethod3(Model model) {
		
		
		String lastname = (String)model.getAttribute("lastName");
		System.out.println(lastname);
		
		
		model.addAttribute("lastName", lastname);
		
		model.addAttribute("next", "/normalMethod");
		
		return "index";
	}

}
