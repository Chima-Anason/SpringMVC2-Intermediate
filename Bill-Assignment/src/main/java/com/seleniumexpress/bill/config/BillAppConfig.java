package com.seleniumexpress.bill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.bill.formatter.CreditCardFormatter;
import com.seleniumexpress.bill.formatter.CurrencyFormatter;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.seleniumexpress.bill.controllers")
public class BillAppConfig implements WebMvcConfigurer{

	//Set up View resolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		
//		
//		System.out.println("Inside addFormatter Method in app config class");
//
//		
//		//register the CreditCardFormatter
//		registry.addFormatter(new CreditCardFormatter());
//		
//		//register the CurrencyFormatter
//		registry.addFormatter(new CurrencyFormatter());
//	}
}
