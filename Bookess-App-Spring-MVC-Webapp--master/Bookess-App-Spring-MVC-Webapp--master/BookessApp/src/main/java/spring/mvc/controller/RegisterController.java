package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring.mvc.entity.User;
import spring.mvc.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerPage()
	{
		return "register";
	}
	
	@PostMapping("/register")
	public String register(User user)
	{
		try {
			userService.insertUser(user);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return "redirect: login";
	}

}
