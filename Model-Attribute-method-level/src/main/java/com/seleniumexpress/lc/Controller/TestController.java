package com.seleniumexpress.lc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seleniumexpress.lc.api.WebsiteInfoDTO;

@Controller
public class TestController {
	
	
	@RequestMapping("/test")
	private String testModelAttribute(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		
		System.out.println("@RequestMapping : Inside showWebsiteInfo()");
		
		
		System.out.println(websiteInfoDTO.getWebsiteName());
		System.out.println(websiteInfoDTO.getWebsiteCategory());
		

		return "index";
	}

}
