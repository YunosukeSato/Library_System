package com.example.demo.dto;

import java.io.Serializable;

//import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

// Java Bean to recieve an input of book data to search
@Data
public class BookForm implements Serializable {
	
//	Name
	@NotEmpty(message = "Please enter any book name")
	private String name;
	
}

