package com.example.usermanagement.repository;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User,Integer>
{
	static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	default String RepositoryLog() {
	logger.info("this is a user management repository file ");
      logger.warn("this is a warn message");
      logger.error("this is an error message");
	return "RepositoryLog";
	}
    public List<User> findByCity(String city);
	
	public List<User> findByEmail(String email);
	
}
