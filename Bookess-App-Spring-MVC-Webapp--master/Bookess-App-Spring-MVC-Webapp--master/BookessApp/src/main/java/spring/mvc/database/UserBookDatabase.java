package spring.mvc.database;

import javax.persistence.Query;
 

import java.util.*;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.entity.User;
import spring.mvc.entity.UserBook;

@Repository
public class UserBookDatabase {

	@Autowired
	private SessionFactory factory;
	
	public List<UserBook> getUserBookByReadLater(User user, boolean readLater)
	{
		Session session = factory.openSession();
		String hqlQuery = "FROM UserBook WHERE userId = :userid AND readLater = :readLater";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("userid", user);
		query.setParameter("readLater", readLater);
		List<UserBook> resultList  = query.getResultList();
		session.close();
		return resultList;
	}
	
	public List<UserBook> getUserBookByLiked(User user, boolean like)
	{
		Session session = factory.openSession();
		String hqlQuery = "FROM UserBook WHERE userId = :userid AND liked= :like";
		Query query = session.createQuery(hqlQuery);
		query.setParameter("userId", user);
		query.setParameter("like", like);
		List<UserBook> resultList = query.getResultList();
		session.close();
		return resultList;
	}
	
	public void insertUserBook(UserBook userbook)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(userbook);
		tx.commit();
		session.close();
	}
	
	public UserBook getUserBookById(int id)
	{
		Session session = factory.openSession();
		UserBook userbook = session.get(UserBook.class, id);
		session.close();
		return userbook;
	}
	
	public void deleteUserBook(UserBook userbook)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.remove(userbook);
		tx.commit();
		session.close();
	}
	
}
