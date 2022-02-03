package com.example.usermanagement.feignclient;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;




@FeignClient(value="feign",url="http://localhost:8080/customer")
public interface FeignClient1 {



@GetMapping("/getAll")
String getAllCustomers();

@GetMapping("/{cid}")
String getCustomer();
}