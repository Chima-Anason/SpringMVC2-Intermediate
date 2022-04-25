package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
	private String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userInfoDTO, BindingResult result, HttpServletRequest request) {
		
		
		System.out.println(userInfoDTO.isTermAndCondition());
		
		if(result.hasErrors()) {
			
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}
			
			return "home-page";
		}
		
		//Create a session to capture the userName and it can be accessed by any jsp page or controller
		HttpSession session = request.getSession();
		session.setAttribute("userName", userInfoDTO.getUserName());
		
		
		//write a service which will calculate the % between the username and the crushname
		
		
		return "result-page";
		
	}
}
