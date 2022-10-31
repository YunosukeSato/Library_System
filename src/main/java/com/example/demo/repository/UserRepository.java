package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

// An interface to be implemented by UserRepoImpl
@Repository
public interface UserRepository {
	User findAccount(User user);
	void save(User user);
}
 
