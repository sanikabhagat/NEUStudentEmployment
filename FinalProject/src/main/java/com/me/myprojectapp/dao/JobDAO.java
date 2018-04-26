package com.me.myprojectapp.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.me.myprojectapp.pojo.Job;
import com.me.myprojectapp.pojo.User;


public class JobDAO extends DAO{

	
Session session = (Session)DAO.getSession();
	
	public Job createJob(Job j) throws Exception {
		try {
			begin();
			System.out.println("Inside Student DAO");
			/*getSession().save(j);*/
			getSession().persist(j);
			commit();
			System.out.println("Inside DAO"+j);
			return j;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating job: " + e.getMessage());
		}
	}
	
	
	public ArrayList<Job> getJobs() throws Exception {
		try {
			
			Query q = getSession().createQuery("from Job");
			ArrayList<Job> listOfJobs=(ArrayList<Job>) q.list();		
			
			return listOfJobs;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get user ");
		}
	}
	
	
	public Job getJobToEdit(String jobid) throws Exception {
		try {
			Query q = getSession().createQuery("from Job where jobid = :jobid");
			q.setString("jobid", jobid);
			Job editJob=(Job) q.uniqueResult();		
			System.out.println("Job Found is"+editJob.getJobid());
			return editJob;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get job to be edited ");
		}
	}
	

	public Job editAndSaveJob(Job j) throws Exception {
		try {
			begin();
			System.out.println("Inside Student DAO");
			getSession().save(j);
			commit();
			System.out.println("Inside DAO"+j);
			return j;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating job: " + e.getMessage());
		}
	}
	
	public int deleteJob(String jobid) throws Exception {
		try {
			begin();
			
			Query query = session.createQuery("delete Job where jobid = :jobid");
			query.setString("jobid", jobid);
			int result = query.executeUpdate();
			System.out.println("Inside Student Delete DAO"+result);

			commit();
			
			return result;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating job: " + e.getMessage());
		}
	}
	
	public Job viewEachJob(String jobid) throws Exception {
		try {
			Query q = getSession().createQuery("from Job where jobid = :jobid");
			q.setString("jobid", jobid);
			Job jobDesc=(Job) q.uniqueResult();		
			System.out.println("Job Found is"+jobDesc.getJobid());
			return jobDesc;

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get job to be edited ");
		}
	}
	
	
	public ArrayList<Job> searchJob(String searchjob) throws Exception {
		try {
			Query q = getSession().createQuery("from Job where jobtitle = :jobtitle");
			q.setString("jobtitle", searchjob);
			
ArrayList<Job> searchjobslist=(ArrayList<Job>) q.list();		
			
			return searchjobslist;
			


		} catch (HibernateException e) {
			rollback();
			throw new Exception("Could not get job to be edited ");
		}
	}


}
