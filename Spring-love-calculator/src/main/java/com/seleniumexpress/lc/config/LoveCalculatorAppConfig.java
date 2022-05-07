package com.seleniumexpress.lc.config;

import java.util.Properties;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.seleniumexpress.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.seleniumexpress.lc")
public class LoveCalculatorAppConfig implements WebMvcConfigurer{

	
	//Set up View resolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	@Bean
	public MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		
		return messageSource;
		
	}
	
	

	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		
		return localValidatorFactoryBean;
	}
	
	
	@Bean
	public JavaMailSender getJavaMailSender() {

		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("chitech994@gmail.com");
		javaMailSenderImpl.setPassword("Chitech1234");
		javaMailSenderImpl.setPort(587);

		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.auth", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		javaMailSenderImpl.setJavaMailProperties(mailProperties);

		return javaMailSenderImpl;
	}
	
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		
		
		System.out.println("Inside addFormatter Method in app config class");
		
		//register the PhoneNumberFormatter
		registry.addFormatter(new PhoneNumberFormatter());
	}
	
	
	@Override
	public Validator getValidator() {
		
		return validator();
	}
	
	
	
}
