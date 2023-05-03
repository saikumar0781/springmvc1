package spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import spring.mvc.database.UserBookDatabase;
import spring.mvc.entity.User;
import spring.mvc.entity.UserBook;

@Service
public class UserBookService {
	
	@Autowired
	private UserBookDatabase userbookdb;
	
	public void insertUserBook(UserBook userbook) throws Exception
	{
		try {
			
			userbookdb.insertUserBook(userbook);
		}
		catch(Exception e)
		{
			throw new Exception("Failed to add the read later...");
		}
		
	}
	
	public List<UserBook> getUserBookByReadLater(User user, boolean readLater)
	{
		List<UserBook> userbooks = userbookdb.getUserBookByReadLater(user, readLater);
		
		return userbooks;
	}
	
	public List<UserBook> getUserBookByLiked(User user, boolean like)
	{
		List<UserBook> userbooks = userbookdb.getUserBookByLiked(user, like);
		
		return userbooks;
	}
	
	public UserBook getUserBookById(int id)
	{
		UserBook userbook = userbookdb.getUserBookById(id);
		return userbook;
	}
	
	public void deleteUserBook(int id)
	{
		UserBook userbook = getUserBookById(id);
				userbookdb.deleteUserBook(userbook);
	}

}
