package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

// Entity class to have a book information
@Entity
@Table(name = "BOOKINF")
@Data
public class Book {
	
//	Id
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
//	Book name
	@Column(name = "BOOKNAME")
	private String bookName;
	
//	Author
	@Column(name = "AUTHOR")
	private String author;
	
//	URL
	@Column(name = "URL")
	private String url;

}

