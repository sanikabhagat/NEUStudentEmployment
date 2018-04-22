package com.me.myprojectapp.dao;

import org.hibernate.HibernateException;

import com.me.myprojectapp.pojo.Application;


public class ApplicationsDAO extends DAO{

	
	public Application createApplication(Application a) throws Exception {
		try {
			begin();
			System.out.println("Inside Applications DAO");
			/*getSession().save(j);*/
			getSession().persist(a);
			commit();
			System.out.println("Inside DAO"+a);
			return a;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating applications: " + e.getMessage());
		}
	}
	
}
