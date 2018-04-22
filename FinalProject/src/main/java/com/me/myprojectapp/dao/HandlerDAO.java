package com.me.myprojectapp.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.me.myprojectapp.pojo.Job;
import com.me.myprojectapp.pojo.User;



public class HandlerDAO extends DAO{

			public User getLoggedUser(String email){
			        Criteria cr = getSession().createCriteria(User.class);
			        cr.add(Restrictions.like("emailid", "%"+email+"%"));
			        User user = (User) cr.uniqueResult();
			        return user;
			    }
			
			
			public Job getLoggedJob(String jobid){
		        Criteria cr = getSession().createCriteria(Job.class);
		        cr.add(Restrictions.like("jobid", "%"+jobid+"%"));
		        Job job = (Job) cr.uniqueResult();
		        return job;
		    }
	
}
