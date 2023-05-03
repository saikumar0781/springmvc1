package spring.mvc.database;

import java.util.List;

 
import org.hibernate.Transaction;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

import spring.mvc.dto.LoginDTO;
import spring.mvc.entity.User;

@Repository
public class UserDatabase {

	@Autowired
	private SessionFactory factory;
	
	
	public int getUserId(String email)
	{
		Session session = factory.openSession();
		String hql = "From User where email= :emailid";
		Query query = session.createQuery(hql);
		query.setParameter("emailid", email);
		List<User> user = query.getResultList();
		return user.get(0).getUserId();
	}
	
	public User getUserByEmail(String email)
	{
		int id = getUserId(email);
		Session session = factory.openSession();
		User user = session.get(User.class, id);
		session.close();
		return user;
	}
	
	public void insertUser(User user)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}
	
	 
}