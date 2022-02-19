package com.example.usermanagement.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.eo.UserEO;
import com.example.usermanagement.mapstruct.MapstructMapper;
import com.example.usermanagement.resttemplate.RestTemplateClass;

@Service
public class UserBO implements IUserBO {

	@Autowired
	private UserEO eo;
	
	
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

	return eo.getAll();
	}


	@Override
	public List<UserDto> getUser() {
		logger.info("fetched data in EO by REST TEMPLATE");
		return eo.getUser();
	}

}
