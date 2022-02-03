package com.example.usermanagement.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.example.usermanagement.UserManagementSystemApplication;

@Entity
@Table(name="user_tab")
public class User 
{
    @Id
    @GeneratedValue
    private Integer uid;
   
    @Column
    @NotEmpty(message = "User Name is Required")
    private String username;
    
    @Column
    @NotEmpty(message = "Password is Required")
    @Size(min=4,max=15)
    private String password;
    
    @Column
	@NotEmpty(message = "City is Required")
    private String city;
   
    @Column
    @NotEmpty(message = "Email is Required")
    private String email;
    
    private static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
	String EntityLog() {
	logger.info("this is a customer management entity file ");
      logger.warn("this is a warn message");
      logger.error("this is an error message");
	return "EntityLog";
	}

public User()
{
	
}
public User( Integer uid,String username, String password, String city, String email)
{
	this.uid =uid;
	this.username = username;
	this.password = password;
	this.city = city;
	this.email = email;
}

public Integer getUid() {
	return uid;
}
public void setUid(Integer uid) {
	this.uid = uid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
