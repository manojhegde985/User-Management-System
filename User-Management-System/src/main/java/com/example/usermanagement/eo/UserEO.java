package com.example.usermanagement.eo;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.feignclient.FeignClient1;
import com.example.usermanagement.mapstruct.MapstructMapper;
import com.example.usermanagement.resttemplate.RestTemplateClass;

@Component
public class UserEO implements IUserEO {

	@Autowired
	private FeignClient1 feignClient1;
	
	@Autowired
	private RestTemplateClass restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	public String ServiceLog() {
	logger.info("this is a user management entity file ");
      logger.warn("this is a warn message");
      logger.error("this is an error message");
	return "ServiceLog";
	}
	
	
	

	@Override
	public List<UserDto> getAll() {

	logger.info("fetched data in EO by REST TEMPLATE");
	return restTemplate.getusers();
	}




	@Override
	public List<UserDto> getUser() {
		
		 return feignClient1.getUser();
	}
	
	
}
