package spring.mvc.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.database.BookDatabase;
import spring.mvc.entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDatabase bookDb;
	
	public List<Book> getAllBooks()
	{
		List<Book> books = bookDb.getAllBooks();
		return books;
	}
	
	public Book getBookById(int id)
	{
		Book book = bookDb.getBookById(id);
		return book;
	}

}
