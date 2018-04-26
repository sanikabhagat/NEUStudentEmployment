package com.me.myprojectapp.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.myprojectapp.pojo.Application;
import com.me.myprojectapp.pojo.Job;


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
	
	
	
	public ArrayList<Application> getApplications(String studentid) throws Exception {
		try {
			
			Query q = getSession().createQuery("from Application where studentid = :studentid");
			q.setString("studentid", studentid);
			ArrayList<Application> listOfApplications=(ArrayList<Application>) q.list();		
			
			return listOfApplications;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get the Application of a particular student");
		}
	}
	
	
	public Application viewEachApplication(String applicationid) throws Exception {
		try {
			Query q = getSession().createQuery("from Application where applicationid = :applicationid");
			q.setString("applicationid", applicationid);
			Application applicationDesc=(Application) q.uniqueResult();		
			System.out.println("Application Found is"+applicationDesc.getApplicationid());
			return applicationDesc;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get the Application whose status is to be checked ");
		}
	}
	
	
	public ArrayList<Application> getAllApplications() throws Exception {
		try {
			
			Query q = getSession().createQuery("from Application");
			
			ArrayList<Application> allApplications=(ArrayList<Application>) q.list();		
			
			return allApplications;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get all Applications");
		}
	}
	
	
}
