package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage() {
		
		
		return "home-page";
	}
	
	
	@RequestMapping("/process-homepage")
	private String showResultPage(@RequestParam String userName,@RequestParam String crushName) {
		
		System.out.println("user name Name is : "+userName);
		System.out.println("crush name Name is : "+crushName);
		return "result-page";
		
	}
}
