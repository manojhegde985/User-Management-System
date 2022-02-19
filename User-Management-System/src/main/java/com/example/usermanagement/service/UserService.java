package com.example.usermanagement.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.UserManagementSystemApplication;
import com.example.usermanagement.bo.UserBO;
import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.BusinessException;
import com.example.usermanagement.exception.NoRecordFoundException;
import com.example.usermanagement.mapstruct.MapstructMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserBO bo;
	@Autowired
	private MapstructMapper mapstruct;

	private static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);

	public String ServiceLog() {
		logger.info("this is a user management entity file ");

		return "ServiceLog";
	}

	

	@Override
	public List<User> getAll() {
		logger.info("fetched data in service by REST TEMPLATE");
		return mapstruct.userDtoToUserList(bo.getAll());
	}

	@Override
	public List<User> getUser() {
		logger.info("fetched data in service by REST TEMPLATE");
		return mapstruct.userDtoToUserList(bo.getUser());
	}
}
