package com.seleniumexpress.lc.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.seleniumexpress.lc.api.WebsiteInfoDTO;

@ControllerAdvice
public class GlobalDemo {
	
	@ExceptionHandler(value = Exception.class)
	public String handleAnyExceptio() {
		
		return "exception";
	}
	
	
	@ModelAttribute("websiteInfo")
	public WebsiteInfoDTO getWebsiteInfoDTO() {
		
		System.out.println("*************************");
		System.out.println("@ModelAttribute : Inside getWebsiteInfoDTO()");
		
		WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
		
		websiteInfoDTO.setWebsiteName("Chitech.com");
		websiteInfoDTO.setWebsiteCategory("Education");
		
		System.out.println("*************************");
	
		return websiteInfoDTO;
	}
	
	
	@InitBinder
	public void dataBinder(WebDataBinder binder) {
		//The date format to parse or output your dates
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		//create a new custom editor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		//Register it as the Custom Editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}
	

}
