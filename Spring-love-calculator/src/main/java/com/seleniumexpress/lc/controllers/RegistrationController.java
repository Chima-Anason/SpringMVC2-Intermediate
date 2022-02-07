package com.seleniumexpress.lc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.CommunicationDTO;
import com.seleniumexpress.lc.api.Phone;
import com.seleniumexpress.lc.api.UserRegistrationDTO;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO dto) {
		
		System.out.println("Inside showRegistrationPage Method");
		
		//load and display the saved user data from the database
		Phone phone = new Phone(); 
		phone.setCountryCode("234");
		phone.setUserNumber("55566777");
		
		
		CommunicationDTO communicationDTO =new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		
		dto.setCommunicationDTO(communicationDTO);
		
		return "user-registration-page";
		
	}
	
	@RequestMapping("/registration-success")
	public String processUserRegistration(@ModelAttribute("userReg") UserRegistrationDTO dto) {
		
		
		System.out.println("Inside processUserRegistration Method");
		

		return "registration-success-page";
	}

}
