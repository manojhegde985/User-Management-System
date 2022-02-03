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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.usermanagement.entity.Customer;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.feignclient.FeignClient1;
import com.example.usermanagement.service.IUserService;



@RestController
@RequestMapping(value = "/user")
@EnableFeignClients
public class UserController {
	
	@Autowired
	private FeignClient1 feignClient1;
	
	@Autowired
	private IUserService userService;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/")
    String controller(){
        logger.debug("This is a debug message");
        logger.info("This is a user management controller layer");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        return "controller";
    }
    
    
    static RestTemplate restTemplate = new RestTemplate();
    static String baseURL = "http://localhost:8080/customer/";
    
    @GetMapping("/{cid}")
    public ResponseEntity<Customer> getCatalog(@PathVariable Integer cid){
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
    ResponseEntity<Customer> responseEntity = restTemplate.exchange(baseURL + cid, HttpMethod.GET,requestEntity,Customer.class);
    return responseEntity;
    }


    @GetMapping("/getAll")
    public ResponseEntity<List> getCustomers(){
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Object> requestEntity =new HttpEntity<>(headers);
    ResponseEntity<List> responseEntity = restTemplate.exchange(baseURL + "getAll",HttpMethod.GET,requestEntity,List.class);
    return responseEntity;
    }
    
    @GetMapping("/getAllCustomers")
    public String getAllCustomers() {
    return feignClient1.getAllCustomers();
    }

    @GetMapping("/customers/{cid}")
    public String getCustomer() {
    return feignClient1.getCustomer();
    }

	@PostMapping(value = "/save")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/allUsers")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}
	
	//@GetMapping(value = "/{uid}")
	//public ResponseEntity<User> getUser(@PathVariable Integer uid)
	//{
		//User user =  userService.deleteUser(uid);
		//return new ResponseEntity<User>(user,HttpStatus.OK);
	//}
	
	@DeleteMapping(value = "/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer uid)
	{
		userService.deleteUser(uid);
		String msg = "User with ID: "+uid+"Deleted Successfully";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping(value = "/city/{city}")
	public ResponseEntity<List<User>> getUsersByCity(@PathVariable String city)
	{
		List<User> allUsersByCity = userService.getAllUsersByCity(city);
		return new ResponseEntity<List<User>>(allUsersByCity,HttpStatus.OK);
	}
	
	@GetMapping(value = "/email/{email}")
	public ResponseEntity<List<User>> getUserByEmail(@PathVariable String email)
	{
		List<User> usersByEmail = userService.getAllUserByEmail(email);
		return new ResponseEntity<List<User>>(usersByEmail,HttpStatus.OK);
	}
	
	@GetMapping(value="/{uid}")
	public ResponseEntity<User> getUser(@PathVariable Integer uid)
	{
		User user=userService.getUserById(uid);
		//String msg="User ID is:"+uid;
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
}
