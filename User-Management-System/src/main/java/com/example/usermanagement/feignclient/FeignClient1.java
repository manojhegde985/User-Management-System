package com.example.usermanagement.feignclient;



import org.springframework.web.bind.annotation.GetMapping;

import com.example.usermanagement.dto.UserDto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;




@FeignClient(name="feign",url="http://localhost:8083/customer/")
public interface FeignClient1 {

@GetMapping("/getAll")
public List<UserDto> getUser();


}