package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage() {
		
		
		return "home-page";
	}
	
	//NB:The @RequestParam using bracket u can put the textbox name in bracket and give it a diff variable name
	@RequestMapping("/process-homepage")
	private String showResultPage(@RequestParam("userName") String userName1,@RequestParam("crushName") String crushName1, Model model) {
		
		System.out.println("user name Name is : "+userName1);
		System.out.println("crush name Name is : "+crushName1);
		
		model.addAttribute("userName", userName1);
		model.addAttribute("crushName", crushName1);
		return "result-page";
		
	}
}
