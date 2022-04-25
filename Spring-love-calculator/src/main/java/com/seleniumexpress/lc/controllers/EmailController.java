package com.seleniumexpress.lc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.EmailDTO;

@Controller
public class EmailController {

	@RequestMapping("/sendEmail")
	public String sendEmail( Model model) {
		
		
		model.addAttribute("emailDTO", new EmailDTO());
		//model.addAttribute("userName", userName.toUpperCase());
		
		return "send-email-page";
	}
	
	
	
	@RequestMapping("/process-email")
	public String processEmail(@ModelAttribute("emailDTO") EmailDTO emailDTO, HttpSession session, Model model) {
		
		String userName = (String) session.getAttribute("userName");
		String newUsername = "Mr " + userName;
		
		model.addAttribute("userName", newUsername);
		
		return "process-email-page";
	}
	
}
