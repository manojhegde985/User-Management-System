package com.example.usermanagement.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;


import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.User;



@Mapper(componentModel="spring")
public interface MapstructMapper {
	
	List<User> userDtoToUserList(List<UserDto> list);
	
	
}