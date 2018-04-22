package com.me.myprojectapp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.me.myprojectapp.pojo.Student;


public class StudentDAO extends DAO{

	
	Session session = (Session)DAO.getSession();
	
	public Student register(Student s) throws Exception {
		try {
			begin();
			System.out.println("Inside Student DAO");
			getSession().save(s);
			commit();
			System.out.println("Inside DAO"+s);
			return s;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating student: " + e.getMessage());
		}
	}
	
	
	
	
}
