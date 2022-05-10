package com.seleniumexpress.lc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.seleniumexpress.lc.api.UserInfoDTO;
import com.seleniumexpress.lc.service.LCAppService;

@Controller
@SessionAttributes("userInfo")
public class LCAppController {

	@Autowired
	private LCAppService lcAppService;

	@RequestMapping("/")
	public String showHomePage(Model model) {

		model.addAttribute("userInfo", new UserInfoDTO());

		return "home-page";
	}

	// Using @Valid and BindingResult for Spring MVC form validation
	@RequestMapping("/process-homepage")
	private String showResultPage(Model model, @Valid UserInfoDTO userInfoDTO, BindingResult result) {

		model.addAttribute("userInfo",userInfoDTO);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfo", result);
		
		System.out.println(userInfoDTO.isTermAndCondition());

		if (result.hasErrors()) {

			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError temp : allErrors) {
				System.out.println(temp);
			}

			return "home-page";
		}

		// write a service which will calculate the % between the username and the
		// crushname
		String appResult = lcAppService.calculateLove(userInfoDTO.getUserName(), userInfoDTO.getCrushName());
		userInfoDTO.setResult(appResult);

		return "result-page";

	}
}
