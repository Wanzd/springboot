package com.pd.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import com.pd.springboot.filter.VirtualFilter;

@SpringBootApplication
@ServletComponentScan
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new VirtualFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
}
