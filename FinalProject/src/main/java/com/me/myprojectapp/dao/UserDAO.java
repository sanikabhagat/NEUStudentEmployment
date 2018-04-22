package com.me.myprojectapp.dao;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


import com.me.myprojectapp.pojo.User;

public class UserDAO extends DAO{

	Session session = (Session)DAO.getSession();
	
	public User register(User u) throws Exception {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}
	
	public User validateUser(String email) throws Exception{
		System.out.println("Hello");
			Criteria cr = session.createCriteria(User.class);
			cr.add(Restrictions.like("emailid", "%"+email+"%"));
			User user = (User)cr.uniqueResult();
			System.out.println(user);
		return user;
	}
	
	
	public User loginUser(String emailid, String password) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from User where emailid = :useremail and password = :password");
			q.setString("useremail", emailid);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user " + emailid, e);
		}
	}
	
}
