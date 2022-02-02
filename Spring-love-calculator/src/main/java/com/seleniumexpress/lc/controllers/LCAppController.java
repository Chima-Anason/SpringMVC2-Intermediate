package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seleniumexpress.lc.api.UserInfoDTO;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage() {
		
		
		return "home-page";
	}
	

	/*
	 * STEP 2: Using DTO and Creating DTO object
	 * use the captured object to call each property at the view page
	 * after inputting data on the Form the spring internally calls the setter method
	 */
	@RequestMapping("/process-homepage")
	private String showResultPage(UserInfoDTO userInfoDTO, Model model) {
		
		System.out.println("user name Name is : "+userInfoDTO.getUserName());
		System.out.println("crush name Name is : "+userInfoDTO.getCrushName());
		
		model.addAttribute("userInfoDTO", userInfoDTO);
		
		return "result-page";
		
	}
}
