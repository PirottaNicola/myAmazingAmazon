package com.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.controller.ControllerHelper;

@Configuration
public class BeanConfig {

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	ControllerHelper getControllerHelper() {
		return new ControllerHelper();
	}
}
