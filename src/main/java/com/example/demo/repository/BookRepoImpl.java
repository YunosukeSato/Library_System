package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.BookForm;
import com.example.demo.entity.Book;

// Repository class to implement BookRepository
@Repository
public class BookRepoImpl implements BookRepository{
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public BookRepoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
//	Method to find book information from the db
	@Override
	public Book findList(String name) {

		String sql = ("SELECT * FROM BOOKINF WHERE BOOKNAME = ?");
		Book foundBook = null;
		
		try {
			Map<String, Object> bookInf = jdbcTemplate.queryForMap(sql, name);


		if(bookInf != null) {
			foundBook = new Book();
			foundBook.setBookName((String) bookInf.get("BOOKNAME"));
			foundBook.setAuthor((String) bookInf.get("AUTHOR"));
			foundBook.setUrl((String) bookInf.get("URL"));
			} else {
				foundBook = null;
			}
		} catch (EmptyResultDataAccessException e) {
			foundBook = null;
		} catch (Exception e) {
			foundBook = null;
		}
		
		return foundBook;
	}
	
//	Method to add book information to the db
	@Override
	public void addBook(Book book) {
		String sql = "INSERT INTO BOOKINF VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, 
				book.getBookName(), 
				book.getAuthor(),
				book.getUrl());
	}
	
//	Method to delete book from db
	@Override
	public void deleteBook(BookForm form) {
		String sql = "DELETE FROM BOOKINF WHERE BOOKNAME = ?";
		String bookName = (String) form.getName();
		jdbcTemplate.update(sql,
				bookName);
	}
	
//	Method to find all books from db
	@Override
	public List<Book> findAll() {
		String sql = "SELECT * FROM BOOKINF";
		List<Book> books = new ArrayList<>();
		List<Map<String, Object>> lists = jdbcTemplate.queryForList(sql);
		
		for(Map<String, Object> list : lists) {
			Book book = new Book();
			
			book.setBookName((String) list.get("BOOKNAME"));
			book.setAuthor((String) list.get("AUTHOR"));
			book.setUrl((String) list.get("URL"));
			
			books.add(book);
		}
		
		return books;
	}
}
