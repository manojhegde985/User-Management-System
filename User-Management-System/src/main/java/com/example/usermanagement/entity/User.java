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




@Table(name="user_tab")

public class User 
{
    @Id
    @GeneratedValue
    private Integer cid;
    
    @Column
    @NotEmpty(message = "User Name is Required")
    private String cname;
   
   
   
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

public User(Integer cid, @NotEmpty(message = "User Name is Required") String cname,
		@NotEmpty(message = "City is Required") String city, @NotEmpty(message = "Email is Required") String email) {
	super();
	this.cid = cid;
	this.cname = cname;
	this.city = city;
	this.email = email;
}

public Integer getCid() {
	return cid;
}

public void setCid(Integer cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
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

public static Logger getLogger() {
	return logger;
}


}
