package com.seleniumexpress.lc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.WebsiteInfoDTO;

@Controller
@ControllerAdvice
//@ControllerAdvice(assignableTypes = {TestController.class, xyz.class}) -> Use this way to Restrict the ControllerAdvice to some specific controllers
//@ControllerAdvice(basePackages = {"com.seleniumexpress.lc.controller", "com.seleniumexpress.lc.xyz"})  -> Use this way to Restrict the ControllerAdvice to some specific packages
public class MyWebsiteController {
	
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

	@RequestMapping("/showInfo")
	private String showWebsiteInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		
		System.out.println("@RequestMapping : Inside showWebsiteInfo()");
		
		
		System.out.println(websiteInfoDTO.getWebsiteName());
		System.out.println(websiteInfoDTO.getWebsiteCategory());
		

		return "index";
	}
	
	
	@RequestMapping("/showCompanyInfo")
	private String showCompanyInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		
		System.out.println("@RequestMapping : Inside showCompanyInfo()");
		
		System.out.println(websiteInfoDTO.getWebsiteName());
		System.out.println(websiteInfoDTO.getWebsiteCategory());
		


		return "index";
	}
}
