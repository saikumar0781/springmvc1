package spring.mvc.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import spring.mvc.service.BookService;
import spring.mvc.entity.Book;


@Controller
public class HomePageController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/homepage")
	public String homePageBooks(Map<String, List<Book>> map)
	{
		List<Book> books = bookService.getAllBooks();
		map.put("books", books);
		return "showbooks";
	}

}
