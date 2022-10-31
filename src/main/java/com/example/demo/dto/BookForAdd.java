package com.example.demo.dto;

import java.io.Serializable;

//import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

// Java Bean to recieve an input  of book data to add
@Data
public class BookForAdd implements Serializable {
	
//	Name
	@NotEmpty(message = "Please add book name")
	private String name;
	
//	Author
	@NotEmpty(message = "Plese add author name")
	private String author;
	
//	URL
	@NotEmpty(message = "Please add URL")
	private String url;
	
}

