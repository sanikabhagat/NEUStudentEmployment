package com.me.myprojectapp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.myprojectapp.dao.AdminDAO;
import com.me.myprojectapp.dao.ApplicationsDAO;
import com.me.myprojectapp.dao.HandlerDAO;
import com.me.myprojectapp.dao.JobDAO;
import com.me.myprojectapp.dao.StudentDAO;
import com.me.myprojectapp.dao.UserDAO;
import com.me.myprojectapp.pojo.Application;
import com.me.myprojectapp.pojo.Job;
import com.me.myprojectapp.pojo.User;

@Controller
public class UserController {

	@RequestMapping(value = "/user/viewalljobs.htm", method = RequestMethod.GET)
	public ModelAndView showViewAllJobsForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, StudentDAO studentDao, Job job, JobDAO jobDao,ModelMap map) {
		

		try {
			ArrayList<Job> listOfJobs=jobDao.getJobs();
			map.addAttribute("listOfJobs",listOfJobs);
			for(Job eachjob:listOfJobs) {
				
				System.out.println("Each Job"+eachjob.getEmployer());
			}
		}
		catch(Exception e) {
			System.out.println("Inside Job List Exception"+e);
		}
		
		
		
		return new ModelAndView("viewalljobs","map",map);
	}
	
	
	
	@RequestMapping(value = "/user/viewalljobs.htm", method = RequestMethod.POST)
	public ModelAndView showViewJobsForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, StudentDAO studentDao, Job job, JobDAO jobDao,ModelMap map) {
		


		//HttpSession session = request.getSession();
		
			String jobid = request.getParameter("job");
			System.out.println(jobid);
			
	
			try {
				Job jobDesc=jobDao.viewEachJob(jobid);
				map.addAttribute("jobDesc",jobDesc);
				
					System.out.println("Each Job"+jobDesc);
			
			}
			catch(Exception e) {
				System.out.println("Inside Job List Exception"+e);
			}
			

		return new ModelAndView("applyjob","map",map);
		
	}


	@RequestMapping(value = "/user/viewjobinformation.htm", method = RequestMethod.POST)
	public ModelAndView showViewAllJobsJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,JobDAO jobDao, ModelMap map) {

		//HttpSession session = request.getSession();
		
			String jobId=request.getParameter("jobid");
			System.out.println(jobId);
			try {
				Job jobDesc=jobDao.viewEachJob(jobId);
				map.addAttribute("jobDesc",jobDesc);
				
					System.out.println("ABA ABA ABC Job ID is:"+jobId);
			
			}
			catch(Exception e) {
				System.out.println("Inside Job List Exception"+e);
			}
			

		return new ModelAndView("applyjob","map",map);
		
		
	}


@RequestMapping(value = "/user/viewjobinformation.htm", method = RequestMethod.GET)	
public ModelAndView showJobInformationForm(HttpServletRequest request, UserDAO userDao, StudentDAO studentDao, AdminDAO adminDao, JobDAO jobDao,ModelMap map) {
		
		String jobId=request.getParameter("jobid");
		try {
			Job jobDesc=jobDao.viewEachJob(jobId);
			map.addAttribute("jobDesc",jobDesc);
			
				System.out.println("Each Job"+jobDesc);
		
		}
		catch(Exception e) {
			System.out.println("Inside Job List Exception"+e);
		}
		
		return new ModelAndView("viewjobinformation","map",map);
	}

	


@RequestMapping(value = "/user/applyjob.htm", method = RequestMethod.GET)	
public ModelAndView showApplyJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, JobDAO jobDao,ModelMap map) {
		
	/*	String job=request.getParameter("job");
		System.out.println(job);
		try {
			Job jobDesc=jobDao.viewEachJob(job);
			map.addAttribute("jobDesc",jobDesc);
			
				System.out.println("Each Job"+jobDesc);
		
		}
		catch(Exception e) {
			System.out.println("Inside Job List Exception"+e);
		}*/
		
		return new ModelAndView("applyjob","map",map);
	}


@RequestMapping(value = "/user/applyjob.htm", method = RequestMethod.POST)	
public ModelAndView showApplySuccessForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, StudentDAO studentDao, HandlerDAO handlerDao, JobDAO jobDao,ModelMap map, ApplicationsDAO applicationDao) {
		
		String jobId=request.getParameter("jobid");
		/*Captcha captcha = Captcha.load(request, "CaptchaObject");*/
		//String captchaCode = request.getParameter("captchaCode");
		HttpSession session = request.getSession();
		if(true) {
		/*if (captcha.validate(captchaCode)) {*/
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String emailid=request.getParameter("emailid");
			String nuid=request.getParameter("nuid");
			String skills=request.getParameter("skills");
			String experience=request.getParameter("experience");
			String grade=request.getParameter("grade");
			
			String loggeduser=request.getParameter("emailid");
			
			User loggeduserobject=handlerDao.getLoggedUser(loggeduser);
			/*Job jobtobeapplied*/
			
			System.out.println("ABAABCABC");
			System.out.println("ABCABCABC"+loggeduser);
			
			Application application=new Application();
			application.setFirstname(firstname);
			application.setLastname(lastname);
			application.setEmailid(emailid);
			application.setNuid(nuid);
			application.setSkills(skills);
			application.setExperience(experience);
			application.setGrade(grade);
			
			application.setUser(loggeduserobject);
			
			
			try {
				
				Application a=applicationDao.createApplication(application);
				
				System.out.println(a);
				System.out.println("Helllllllllllllllooooooooooooo JOb"+a);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			//map.addAttribute("errorMessage", "Invalid Captcha!");
			return new ModelAndView ("applyjob");
		}

		return new ModelAndView("redirect:/user/applysuccess.htm");
		
	}

@RequestMapping(value = "/user/applysuccess.htm", method = RequestMethod.GET)	
public ModelAndView showApplySuccessSucessForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, JobDAO jobDao,ModelMap map) {
		
		/*String jobId=request.getParameter("jobid");
		try {
			Job jobDesc=jobDao.viewEachJob(jobId);
			map.addAttribute("jobDesc",jobDesc);
			
				System.out.println("Each Job"+jobDesc);
		
		}
		catch(Exception e) {
			System.out.println("Inside Job List Exception"+e);
		}*/
		
		return new ModelAndView("applysuccess");
	}

}







