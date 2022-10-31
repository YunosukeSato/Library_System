package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

// Service class to invoke some methods about account
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
//	Create an account 
	public void create(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setPass(userRequest.getPass());
		userRepository.save(user);
	}
	
//	Check an account information to login
	public User checkAccount(User user) {
		
		User foundUser = new User();
		foundUser = userRepository.findAccount(user);
		
		return foundUser;
	}
}
