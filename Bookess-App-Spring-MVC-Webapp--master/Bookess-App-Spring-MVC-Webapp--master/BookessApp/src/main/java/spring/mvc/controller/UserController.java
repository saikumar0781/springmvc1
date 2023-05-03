package spring.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;

import spring.mvc.database.UserBookDatabase;

public class UserController {
	
	private UserBookDatabase db;
	
	@GetMapping("/Get")
	public void getAll()
	{}

}
