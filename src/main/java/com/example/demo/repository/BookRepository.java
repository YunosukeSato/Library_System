package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.BookForm;
import com.example.demo.entity.Book;

// An interface to be implemented by BookRepoImpl 
@Repository
public interface BookRepository {
	Book findList(String name);
	void addBook(Book book);
	void deleteBook(BookForm form);
	List<Book> findAll();
}
 
