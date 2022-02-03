package com.example.usermanagement.BO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.entity.User;

public interface IUserBO 
{
	static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	  public default String ServiceLog() {
		logger.info("this is a user management entity file ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
		return "ServiceLog";
		}

	public User saveUser(User user);
	
	public List<User> getAllUsers();
	
	//public Optional<User> getUserById(Integer uid);
	public User deleteUser(Integer uid);
	
	public User updateUser(User user);
	
	public List<User> getAllUsersByCity(String city);
	
	//public Optional<User> getUserByEmail(String email);
	public List<User> getAllUserByEmail(String email);
	
	public User getUserById(Integer uid);
	
}