package com.example.usermanagement.service;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.BO.UserBO;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.mapstruct.MapstructMapper;
import com.example.usermanagement.repository.UserRepo;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserBO userRepo;
	private MapstructMapper mapstruct;
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	public String ServiceLog() {
	logger.info("this is a user management entity file ");
      logger.warn("this is a warn message");
      logger.error("this is an error message");
	return "ServiceLog";
	}
	
	@Autowired
	public UserService(
	MapstructMapper mapstruct,
	 UserBO userRepo
	)
	{
	this.mapstruct = mapstruct;
	this.userRepo= userRepo;
	}


	
	@Override
	public User saveUser(User user) {
			return userRepo.saveUser(mapstruct.userToUserGetdto(user));
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.getAllUsers();
		System.out.println("Getting data from DB : +users");
		return users;
	}
	

	

	@Override
	public User deleteUser(Integer uid) {
		userRepo.deleteUser(uid);
          return null;
	}


	@Override
	public User updateUser(User user) {
		return userRepo.saveUser(user);
	}

	@Override
	public List<User> getAllUsersByCity(String city) {
		return userRepo.getAllUsersByCity(city);
	}
	
	@Override
	public List<User> getAllUserByEmail(String email) {
		return userRepo.getAllUserByEmail(email);
	}
   
	@Override
    public User getUserById(Integer uid) {
		return userRepo.getUserById(uid);
}
}