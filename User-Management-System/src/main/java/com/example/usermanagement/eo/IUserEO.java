package com.example.usermanagement.eo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.User;

public interface IUserEO 
{
	static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	  public default String ServiceLog() {
		logger.info("this is a user management entity file ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
		return "ServiceLog";
		}

	
	public List<UserDto> getAll();
	
	public List<UserDto> getUser();
	
}