package com.seleniumexpress.lc.config;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.seleniumexpress.lc")
public class LoveCalculatorAppConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	Logger logger = Logger.getLogger(LoveCalculatorAppConfig.class.getName());

	
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
	
	
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//
//		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
//		
//		//System.out.println(env.getProperty("mail.host"));
//		logger.info(">>>>>>>>Fetching the host value " + env.getProperty("mail.host"));
//		
//		javaMailSenderImpl.setHost(env.getProperty("mail.host"));
//		javaMailSenderImpl.setUsername(env.getProperty("mail.username"));
//		javaMailSenderImpl.setPassword(env.getProperty("mail.password"));
//		javaMailSenderImpl.setPort(getIntProperty("mail.port"));
//
//
//		javaMailSenderImpl.setJavaMailProperties(getMailProperties());
//
//		return javaMailSenderImpl;
//	}
//
//
//	private Properties getMailProperties() {
//		Properties mailProperties = new Properties();
//		mailProperties.put("mail.smtp.starttls.enable", true);
//		mailProperties.put("mail.smtp.auth", true);
//		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//		return mailProperties;
//	}
//	
//	int getIntProperty(String key) {
//
//		String property = env.getProperty(key);
//
//		return Integer.parseInt(property);
//	}
	
	
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		
//		
//		System.out.println("Inside addFormatter Method in app config class");
//		
//		//register the PhoneNumberFormatter
//		registry.addFormatter(new PhoneNumberFormatter());
//	}
	
	
	@Override
	public Validator getValidator() {
		
		return validator();
	}
	
	
	
	
	
	
}
