package spring.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

import spring.mvc.entity.Book;
import spring.mvc.entity.User;
import spring.mvc.entity.UserBook;
import spring.mvc.service.BookService;
import spring.mvc.service.UserBookService;
import spring.mvc.service.UserService;

public class DashboardController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private UserBookService userBookService;
	
	@GetMapping
	public String dashboardPage(Map<String, List<Book>> map)
	{
		List<Book> books = bookService.getAllBooks();
		map.put("books", books);
		return "Dashboard";
	}
	
	@GetMapping("/readlater/{bookid}")
	public String addToReadLater(@PathVariable int bookid, HttpSession session)
	{
		User user = (User) session.getAttribute("user");		
		System.out.println(user);
		Book book = bookService.getBookById(bookid);
		boolean readLater = true;
		UserBook userBook = new UserBook();
		userBook.setUserId(user);
		userBook.setBookId(book);
		userBook.setReadLater(readLater);
		
		try {
			userBookService.insertUserBook(userBook);
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());			
		}
		return "redirect:/readlater";
		
	}
	
	@GetMapping("/liked/{bookid}")
	public String addToLikedBook(@PathVariable int bookid, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		System.out.println(user);
		Book book = bookService.getBookById(bookid);
		boolean likedbook = true;
		UserBook userBook = new UserBook();
		userBook.setUserId(user);
		userBook.setBookId(book);
		userBook.setLiked(likedbook);
		
		try {
			userBookService.insertUserBook(userBook);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return "redirect:/like";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("user");
		session.invalidate();
		return "redirect:/login";
	}

}
