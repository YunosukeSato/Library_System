package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookForAdd;
import com.example.demo.dto.BookForm;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

// Service class to invoke some methods about book information
@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
//	Method to find book information from db
	public Book findList(String name) {
		return bookRepository.findList(name);
	}
	
//	Method to add a book information to the db
	public void addBook(BookForAdd bfa) {
		Book book = new Book();
		book.setBookName(bfa.getName());
		book.setAuthor(bfa.getAuthor());
		book.setUrl(bfa.getUrl());
		
		bookRepository.addBook(book);
	}
	
//	Method to delete a book information from the db
	public void deleteBook(BookForm form) {
		bookRepository.deleteBook(form);
	}
	
//	Method to find all book data from db
	public List<Book> searchAll() {
		return bookRepository.findAll();
	}
}
