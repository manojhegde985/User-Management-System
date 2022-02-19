package com.example.usermanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.entity.Customer;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.exception.BusinessException;
import com.example.usermanagement.exception.ControllerException;
import com.example.usermanagement.exception.InvalidFieldException;
import com.example.usermanagement.exception.UserNotFoundException;
import com.example.usermanagement.feignclient.FeignClient1;
import com.example.usermanagement.mapstruct.MapstructMapper;
import com.example.usermanagement.service.IUserService;



@RestController
@RequestMapping(value = "/user")
@EnableFeignClients
public class UserController {
	
	
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private MapstructMapper mapstruct;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/")
    String controller(){
       
        logger.info("This is a user management controller layer");
        return "controller";
    }
    
      
    //Rest template
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<User>> getAll()
    {
    List<User> allUsers = userService.getAll();
    logger.info("fetched data in controller by REST TEMPLATE");
    return new ResponseEntity<List<User>>(allUsers , HttpStatus.OK);

    }
    
    
    //Feign client
    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllCustomers() {
    	 List<User> allUsers = userService.getUser();
    	    logger.info("fetched data in controller by FEIGN CLIENT");
    	    return new ResponseEntity<List<User>>(allUsers , HttpStatus.OK);
    
    }

		
	}

