package spring.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import spring.mvc.entity.User;
import spring.mvc.entity.UserBook;
import spring.mvc.service.BookService;
import spring.mvc.service.UserBookService;

public class UserBookController {
	
	@Autowired
	private UserBookService userBookService;
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("readlater")
	public String readLater(Map<String, List<UserBook>> map, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		List<UserBook> userBook = userBookService.getUserBookByReadLater(user, true);
		map.put("userbook", userBook);
		return "readlater";
	}
	
	@GetMapping("like")
	public String liked(Map<String, List<UserBook>> map, HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		List<UserBook> userBook = userBookService.getUserBookByLiked(user, true);
		map.put("userbook", userBook);
		return "liked";		
	}
	
	@GetMapping("/removelike/{userbookid}")
	public String removeLiked(@PathVariable int userbookid)
	{
		userBookService.deleteUserBook(userbookid);
		return "redirect:/like";
	}
	
	@GetMapping("/removereadlater/{userbookid}")
	public String removeReadLater(@PathVariable int userbookid)
	{
		userBookService.deleteUserBook(userbookid);
		return "redirect:/readlater";
	}

}
