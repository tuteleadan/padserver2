package com.proiectpad2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Server2Application {

	public static void main(String[] args) {
		SpringApplication.run(Server2Application.class, args);
	}

	@Bean
	public FilterRegistrationBean corsFilterRegistration() {
		FilterRegistrationBean registrationBean =
				new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}


}
