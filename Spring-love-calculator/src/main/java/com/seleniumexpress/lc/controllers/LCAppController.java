package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage() {
		
		
		return "home-page";
	}
	
	
	@RequestMapping("/process-homepage")
	private String showResultPage() {
		
		return "result-page";
		
	}
}
