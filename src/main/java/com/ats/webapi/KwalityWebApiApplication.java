package com.ats.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ats.webapi.exception.ConfigServiceExceptionHandler;

@SpringBootApplication
public class KwalityWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KwalityWebApiApplication.class, args);
	}

	@Bean
	public ConfigServiceExceptionHandler configServiceExceptionHandler() {
		ConfigServiceExceptionHandler configServiceExceptionHandler = new ConfigServiceExceptionHandler();
		return configServiceExceptionHandler;
	}

}
