package com.example.usermanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.User;

public interface IUserService 
{
	static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	  public default String ServiceLog() {
		logger.info("this is a user management entity file ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
		return "ServiceLog";
		}

	public List<User> getAll();
	
	public List<User> getUser();
	
	
}
