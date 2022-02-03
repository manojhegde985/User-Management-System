package com.example.usermanagement.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.persistence.JoinColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;

import com.example.usermanagement.UserManagementSystemApplication;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name="customer_table")
public class Customer {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer cid;
		
		@Column
		@NotEmpty(message = "Customer Name is Required")
		private String cname;
		
		@Column
		@NotEmpty(message = "City is Required")
		private String city;
		
		@Column
		@NotEmpty(message = "Email is Required")
		@JsonProperty("email")
		private String email;
		
		private static final Logger logger = LoggerFactory.getLogger(UserManagementSystemApplication.class);
		String EntityLog() {
		logger.info("this is a customer management entity file ");
	      logger.warn("this is a warn message");
	      logger.error("this is an error message");
		return "EntityLog";
		}
		
		public Customer() {
			super();
		}
		
		public Customer(Integer cid, String cname, String city, String email) {
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
			
}
		



