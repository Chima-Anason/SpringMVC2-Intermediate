package com.seleniumexpress.lc.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {
	
	public final String LC_APP_FORMULA = "FLAME";

	@Override
	public String calculateLove(String userName, String crushName) {
		
		int userAndCrushNameCount = (userName+crushName).toCharArray().length;
		int formulaCount = LC_APP_FORMULA.toCharArray().length;
		
		int rem = userAndCrushNameCount % formulaCount;
		
		char resultChar = LC_APP_FORMULA.charAt(rem);
		
		String result = whatsBetweenUs(resultChar);
		
		
		return result;

	}

	@Override
	public String whatsBetweenUs(char calculationResult) {
		 
		String result = null;
		
		if (calculationResult == 'F') {
			
			result = LoveCalculatorConstant.F_CHAR_MEANING;
		}
		else if(calculationResult == 'L') {
			
			result = LoveCalculatorConstant.L_CHAR_MEANING;
		}
		else if(calculationResult == 'A') {
			
			result = LoveCalculatorConstant.A_CHAR_MEANING;
		}
		else if(calculationResult == 'M') {
			
			result = LoveCalculatorConstant.M_CHAR_MEANING;
		}
		else if(calculationResult == 'E') {
			
			result = LoveCalculatorConstant.E_CHAR_MEANING;
		}
		
		
		return result;
	}

}
