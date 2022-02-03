package com.example.usermanagement.mapstruct;

import org.springframework.stereotype.Component;

import com.example.usermanagement.entity.User;



@Component
public class MapstructMapperImpl implements MapstructMapper {



@Override
public User userToUserGetdto(User user) {
if ( user == null ) {
return null;

}
User userdto = new User();



userdto.setUid( user.getUid());
userdto.setUsername( user.getUsername());
userdto.setPassword( user.getPassword());
userdto.setCity( user.getCity());
userdto.setEmail( user.getEmail());




return userdto;
}

}

