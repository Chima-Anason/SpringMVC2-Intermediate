package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.UserInfoDTO;

@Controller
public class LCAppController {

	/*
	 * STEP 3: Using Spring MVC Form Tag
	 * SHORTCUT -: Introducing @ModelAttribute
	 */
	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfodto) {
		
		//Reading the default value of properties by fetching from DTO(display default-value on home-page when loaded)
		
		return "home-page";
	}
	


	@RequestMapping("/process-homepage")
	private String showResultPage(@ModelAttribute("userInfoDTO") UserInfoDTO userInfoDTO) {
		
		//Writing the values to the properties by fetching from the URL
		
		return "result-page";
		
	}
}
