package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// Entity class to have an user information
@Entity
@Table(name = "USERS")
@Data
public class User {
//	Id
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	Username
	@Column(name = "USERNAME")
	private String name;
	
//	Password
	@Column(name = "PASS")
	private String pass;
	
}

