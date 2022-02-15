package com.seleniumexpress.lc.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower; 
	private int upper; 
	
	@Override
	public void initialize(Age age) {
		//i can write post construct work here
		this.lower = age.lower();
		this.upper = age.upper();
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// Logic
		if (age == null) {
			return false; //fail
		}
		if (age < lower || age > upper) {
			
			return false; //fail
		}
		
		
		return true; //pass
	}

}
