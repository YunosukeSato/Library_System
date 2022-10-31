package com.example.demo.dto;

import java.io.Serializable;

//import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

// Java Bean to recieve an input of user information to login and sign up
@Data
public class UserRequest implements Serializable {
	
//	Name
	@NotEmpty(message = "Please enter an username")
	@Size(max = 10, message = "Up to 10 characters")
	private String name;
	
//	Password
	@NotEmpty(message = "Please enter a password")
	@Size(max = 10, message = "Up to 10 characters")
	private String pass;
}
