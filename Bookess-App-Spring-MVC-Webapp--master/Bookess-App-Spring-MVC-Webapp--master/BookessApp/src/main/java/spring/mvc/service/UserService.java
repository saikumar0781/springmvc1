package spring.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.database.UserDatabase;
import spring.mvc.dto.LoginDTO;
import spring.mvc.entity.User;

@Service
public class UserService {

	@Autowired
	UserDatabase userDb;
	
	 public User getUserByEmail(String email) throws Exception
	 {
		 try {
			 User user = userDb.getUserByEmail(email);
			 return user;
			 
		 }
		 
		 catch(Exception e)
		 {
			 throw new Exception("Invalid credentials...");			 
		 }
		 
	 }
	 
	 public boolean validateUser(User user, String password) throws Exception
	 {
		 try {
			 if(user.getPassword().equals(password)) return true;
		 }
		 catch(Exception e){
			 throw new Exception("Invalid credentials...");
		 }
		 
		 return false;
	 }
	 
	 public void insertUser(User user) throws Exception
	 {
		 try {
			 userDb.insertUser(user);
		 }
		 catch(Exception e)
		 {
			 throw new Exception(e.getMessage());
		 }
	 }
}