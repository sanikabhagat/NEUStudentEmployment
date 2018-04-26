package com.me.myprojectapp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.myprojectapp.dao.AdminDAO;
import com.me.myprojectapp.dao.ApplicationsDAO;
import com.me.myprojectapp.dao.JobDAO;
import com.me.myprojectapp.dao.StudentDAO;
import com.me.myprojectapp.dao.UserDAO;
import com.me.myprojectapp.pojo.Application;
import com.me.myprojectapp.pojo.Job;

@Controller
public class AdminController {

	
	/* ----------------------------- View All Applications GET and POST Method ------------------------------- */
	
	
	@RequestMapping(value = "/user/viewallapplications.htm", method = RequestMethod.GET)
	public ModelAndView showViewAllApplicationsForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, ApplicationsDAO applicationDao, StudentDAO studentDao, Job job, JobDAO jobDao,ModelMap map) {
		

		try {
			ArrayList<Application> allApplications=applicationDao.getAllApplications();
			map.addAttribute("allApplications",allApplications);
			for(Application eachapplication:allApplications) {
				
				System.out.println("Each Job"+eachapplication.getApplicationid());
			}
		}
		catch(Exception e) {
			System.out.println("Inside All Applications List Exception"+e);
		}
		
		
		
		return new ModelAndView("viewallapplications","map",map);
	}
	
	
	
	/*@RequestMapping(value = "/user/viewalljobs.htm", method = RequestMethod.POST)
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
		
	}*/
	
	/* ---------------------------------------------------------------------------------------------------------- */
	
}
