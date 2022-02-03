package com.example.usermanagement.mapstruct;

import org.mapstruct.Mapper;

import com.example.usermanagement.entity.User;



@Mapper(componentModel="spring")
public interface MapstructMapper {
User userToUserGetdto(User user);

}