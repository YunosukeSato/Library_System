package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.BookForAdd;
import com.example.demo.dto.BookForm;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.service.BookService;
import com.example.demo.service.UserService;

// User information Controller
@Controller
public class UserController {
//	User information Service
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	
//	Return top page
	@GetMapping(value = "/top")
	public String displayTop(Model model) {
		model.addAttribute("loginRequest", new UserRequest());
		return "user/top";
	}
	
//	Method to check the user if there is that account in db already
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute UserRequest userRequest, Model model) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setPass(userRequest.getPass());
		
		User foundUser = userService.checkAccount(user);
		User admin = new User();
		admin.setName("Yuno");
		admin.setPass("Sato");
		
		
		if(foundUser == null) {
			return "user/loginError";
		} else if(foundUser.getName().equals(admin.getName()) && foundUser.getPass().equals(admin.getPass())) {
			return "admin/adminLogin";
		} else {
			return "user/loginResult";
		}
	}
	
	
//	Return sign up page
	@GetMapping(value = "/user/add")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "user/add";
	}
	
//	Add new user to the db
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String create(@Validated UserRequest userRequest, BindingResult result) {
		if(result.hasErrors()) {
			return "user/signUpError";
		}
		userService.create(userRequest);
		return "user/signUpResult";
	}
	
	
//	Return main page
	@GetMapping(value = "/user/main")
	public String displayMain(Model model) {
		model.addAttribute("bookForm", new BookForm());
		List<Book> allBooks = bookService.searchAll();
		model.addAttribute("allBooks", allBooks);
		return "user/main";
	}
	
//	Return sign up result page
	@GetMapping(value = "/signUpResult")
	public String signUpResult() {
		return "user/signUpResult";
	}
	
//	Return Main page for admin
	@GetMapping(value = "/adminMain")
	public String displayAdminMain(Model model) {
		model.addAttribute("bookForm", new BookForm());
		model.addAttribute("bookForAdd", new BookForAdd());
		List<Book> allBooks = bookService.searchAll();
		model.addAttribute("allBooks", allBooks);
		return "admin/adminMain";
	}
	
}
