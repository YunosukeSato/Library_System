package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.BookForAdd;
import com.example.demo.dto.BookForm;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

// Book information Controller
@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
//	Method to search a book
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchBook(@ModelAttribute BookForm form, Model model) {
		Book foundBook = bookService.findList(form.getName());
		if(foundBook != null) {
			Map<String, String> bookInf = new HashMap<>();
			bookInf.put("bookName", foundBook.getBookName());
			bookInf.put("author", foundBook.getAuthor());
			bookInf.put("url", foundBook.getUrl());
			model.addAttribute("bookInf", bookInf);
			
			return "user/list";
		} else {
			return "user/notFound";
		}
	
		
	}
	
//	Method to search for admin
	@RequestMapping(value = "/adminSearch", method = RequestMethod.GET)
	public String searchBookAdmin(@ModelAttribute BookForm form, Model model) {
		Book foundBook = bookService.findList(form.getName());
		if(foundBook != null) {
			Map<String, String> bookInf = new HashMap<>();
			bookInf.put("bookName", foundBook.getBookName());
			bookInf.put("author", foundBook.getAuthor());
			bookInf.put("url", foundBook.getUrl());
			model.addAttribute("bookInf", bookInf);
			
			return "admin/adminBookList";
		} else {
			return "admin/adminBookNotFound";
		}
		
		
	}
	
//	Method to add a book to db
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String addBook(@Validated BookForAdd bfa, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "admin/additionError";
		}
		bookService.addBook(bfa);
		
		return "/admin/addBookResult";
		
	}
	
//	Method to delete a book from db
	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public String deleteBook(@Validated BookForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "admin/deleteError";
		}
		bookService.deleteBook(form);
		
		return "/admin/deleteBookResult";
	}
}
