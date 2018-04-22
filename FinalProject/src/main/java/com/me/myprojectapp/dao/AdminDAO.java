package com.me.myprojectapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.me.myprojectapp.pojo.Admin;



public class AdminDAO extends DAO{
		
		Session session = (Session)DAO.getSession();
		
		public Admin register(Admin s) throws Exception {
			try {
				begin();
				System.out.println("Inside Student DAO");
				getSession().save(s);
				commit();
				System.out.println("Inside DAo"+s);
				return s;

			} catch (HibernateException e) {
				rollback();
				throw new Exception("Exception while creating admin: " + e.getMessage());
			}
		}
		
}
