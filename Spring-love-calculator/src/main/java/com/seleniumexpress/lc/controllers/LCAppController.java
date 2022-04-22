package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.UserInfoDTO;

@Controller
public class LCAppController {

	
	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userInfodto) {
		
		
		
		return "home-page";
	}
	


	//Using @Valid and BindingResult for Spring MVC form validation
	@RequestMapping("/process-homepage")
	private String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result, HttpServletResponse response) {
		
		
		System.out.println(userInfoDTO.isTermAndCondition());
		
		if(result.hasErrors()) {
			
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			
			return "home-page";
		}
		
		//Create a cookie for the user name
		Cookie theCookie = new Cookie("lcApp.userName", userInfoDTO.getUserName());
		theCookie.setMaxAge(60*60*24); //expiring time of the cookie
		
		
		//add the cookie to the response
		response.addCookie(theCookie);
		
		
		//write a service which will calculate the % between the username and the crushname
		
		
		return "result-page";
		
	}
}
