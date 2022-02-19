package com.example.usermanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableFeignClients
@EnableConfigServer
public class UserManagementSystemApplication {
	private static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	public static void main(String[] args) {
		logger.info("this is a customer management spring boot application ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
	
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate()
	{
	return new RestTemplate();
	}

}
