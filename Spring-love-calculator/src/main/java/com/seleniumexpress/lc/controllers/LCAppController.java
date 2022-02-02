package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.UserInfoDTO;

@Controller
public class LCAppController {

	@RequestMapping("/")
	public String showHomePage(Model model) {
		
		//Reading the default value of properties by fetching from DTO(display default-value on home-page when loaded)
		UserInfoDTO userInfo = new UserInfoDTO();
		model.addAttribute("userInfo", userInfo);
		
		
		return "home-page";
	}
	

	/*
	 * STEP 2: Using DTO and Creating DTO object
	 * use the captured object to call each property at the view page
	 * after inputting data on the Form the spring internally calls the getter method
	 */
	@RequestMapping("/process-homepage")
	private String showResultPage(UserInfoDTO userInfoDTO, Model model) {
		
		//Writing the values to the properties by fetching from the URL
		System.out.println("user name Name is : "+userInfoDTO.getUserName());
		System.out.println("crush name Name is : "+userInfoDTO.getCrushName());
		
		model.addAttribute("userInfoDTO", userInfoDTO);
		
		return "result-page";
		
	}
}
