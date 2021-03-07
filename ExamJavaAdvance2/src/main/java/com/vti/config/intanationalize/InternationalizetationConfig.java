package com.vti.config.intanationalize;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class InternationalizetationConfig implements WebMvcConfigurer {
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		// language , country
		resolver.setDefaultLocale(new Locale("vi", "VN"));
		return resolver;
	}

// Định nghĩa parameter để nhập trong body (postman)
	@Bean
	public LocaleChangeInterceptor changeLocaleInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

// add paramater vào 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(changeLocaleInterceptor());
	}

// ĐỊnh nghĩa ra UTF-8
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		// Định nghĩa tên file messages đều bắt đầu bằng messages
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

// set lại validator
	@Bean
	public LocalValidatorFactoryBean getvalidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

}
