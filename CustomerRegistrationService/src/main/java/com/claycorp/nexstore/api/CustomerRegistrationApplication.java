package com.claycorp.nexstore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CustomerRegistrationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}
	
	@Bean
	public ObjectMapper objectMapper() {
	    return new ObjectMapper()
	            .registerModule(new ProblemModule())
	            .registerModule(new ConstraintViolationProblemModule());
	}
}