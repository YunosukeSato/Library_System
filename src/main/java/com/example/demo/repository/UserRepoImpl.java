package com.example.demo.repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

// Repository class to implement UserRepository
@Repository
public class UserRepoImpl implements UserRepository{

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UserRepoImpl(NamedParameterJdbcTemplate jdbc, JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}
	
//	Method to find an account to login
	@Override
	public User findAccount(User user) {

		User foundUser = null;
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		
		try {
			Map<String, Object> account = jdbcTemplate.queryForMap(sql, user.getName());


		if(user.getPass().equals(account.get("PASS"))) {
			foundUser = new User();
			foundUser.setName((String) account.get("USERNAME"));
			foundUser.setPass((String) account.get("PASS"));
			} else {
				foundUser = null;
			}
		} catch (EmptyResultDataAccessException e) {
			foundUser = null;
		} catch (Exception e) {
			foundUser = null;
		}
		
		
		return foundUser;
	}

//	Method to save an account to db
	@Override
	public void save(User user) {
		String sql = "INSERT INTO USERS VALUES(?, ?)";
		jdbcTemplate.update(sql, 
				user.getName(), 
				user.getPass());
	}

}
