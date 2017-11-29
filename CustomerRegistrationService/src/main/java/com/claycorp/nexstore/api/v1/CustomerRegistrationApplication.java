package com.claycorp.nexstore.api.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CustomerRegistrationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerRegistrationApplication.class, args);
	}
}
