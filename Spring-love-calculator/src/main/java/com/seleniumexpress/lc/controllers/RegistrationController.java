package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.CommunicationDTO;
import com.seleniumexpress.lc.api.Phone;
import com.seleniumexpress.lc.api.UserRegistrationDTO;
import com.seleniumexpress.lc.propertyEditor.NamePropertyEditor;

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
	public String processUserRegistration(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto, BindingResult result) {
		
		System.out.println("the user name " + "|" + dto.getName()+ "|");
		
		if (result.hasErrors()) {
			
			System.out.println("My page has errors");
			
			List<ObjectError> allErrors = result.getAllErrors();
			
			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			
			return "user-registration-page";
		}
		
		System.out.println("Inside processUserRegistration Method");
		

		return "registration-success-page";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		
		System.out.println("Inside the init binder method.....");
		
		//Register property editor for trimming string
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);
		
		
		//register our created custom property editor to convert to uppercase
		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", namePropertyEditor);
		
		//binder.setDisallowedFields("name");
		
	}

}
