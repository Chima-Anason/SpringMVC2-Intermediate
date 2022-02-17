package com.seleniumexpress.lc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.seleniumexpress.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator{

	//check if UserNameValidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDTO.class.equals(clazz);
	}

	//we need to write our custom validation logic here!
	@Override
	public void validate(Object object, Errors errors) {
		
		//check if the field is empty or null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "* User name can't be empty");
		
		
		
		//the string should contain a "_"
		String username = ((UserRegistrationDTO)object).getUserName();
		if(!username.contains("_")) {
			
			errors.rejectValue("userName", "userName.invalid", "* String must contain a '_'");
		}
	}

}
