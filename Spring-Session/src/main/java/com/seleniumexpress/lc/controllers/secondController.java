package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class secondController {
	
	@RequestMapping("/normalMethod")
	public String handlermethod1(Model model) {
		
		String firstname = (String)model.getAttribute("firstName");
		System.out.println("inside new controller method, Printing firstName"+firstname);
		
		return "index";
	}

}
