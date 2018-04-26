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
	
	
	
	
	
	@RequestMapping(value = "/user/changeapplicationstatus.htm", method = RequestMethod.POST)
	public ModelAndView showChangeApplicationStatusForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, ApplicationsDAO applicationDao, StudentDAO studentDao, Job job, JobDAO jobDao,ModelMap map) {
		
		System.out.println("Inside Change Appication Status POST Controller");
		
		String applicationid = request.getParameter("applicationid");
		System.out.println("Change App Status POST Application id:"+applicationid);
		System.out.println(applicationid);
		
		/*String appstatus=request.getParameter("appstatus");
		*/
		
			
			/*try {
				
				if(appstatus.equals("accept")) {
				
			
				Application eachApplicationStatusChange=applicationDao.viewEachApplication(applicationid);
				eachApplicationStatusChange.setAppstatus("accept");
		
				}
				
				else if(appstatus.equals("reject")){
					Application eachApplicationStatusChange=applicationDao.viewEachApplication(applicationid);
					eachApplicationStatusChange.setAppstatus("accept");
				}
				
				else{
					Application eachApplicationStatusChange=applicationDao.viewEachApplication(applicationid);
					eachApplicationStatusChange.setAppstatus("pending");
				}
		}
		*/
		
		try {
			Application eachApplicationStatusChange=applicationDao.viewEachApplication(applicationid);
			map.addAttribute("eachApplicationStatusChange",eachApplicationStatusChange);
			
		}
		catch(Exception e) {
			System.out.println("Inside All Applications List Exception"+e);
		}
		
		
		
			return new ModelAndView("changeapplicationstatus","map",map);
	}
	
	
	
	@RequestMapping(value = "/user/editstatus.htm", method = RequestMethod.POST)
	public ModelAndView showViewJobsForm(HttpServletRequest request, UserDAO userDao, ApplicationsDAO applicationDao, AdminDAO adminDao, StudentDAO studentDao, Job job, JobDAO jobDao,ModelMap map) {
		


System.out.println("Inside Change Appication Status POSTtttttttttttttttttttt Controller");
		
		String applicationid = request.getParameter("applicationid");
		System.out.println("Change App Status POSTttttttttttttttttttttt Application id:"+applicationid);
		System.out.println(applicationid);
		
		String appstatus=request.getParameter("appstatus");
		
		
			
			try {
				Application eachApplicationStatusChange=applicationDao.viewEachApplication(applicationid);
				
				
				if(appstatus.equals("accept")) {
			
				eachApplicationStatusChange.setAppstatus("accept");
		
				}
				
				else if(appstatus.equals("reject")){
					
					eachApplicationStatusChange.setAppstatus("reject");
				}
				
				else{
					
					eachApplicationStatusChange.setAppstatus("pending");
				}
				
				System.out.println("STATUS STUA"+eachApplicationStatusChange.getAppstatus());
				
				
				try {
					Application applicationEdited=applicationDao.editAndSaveApplication(eachApplicationStatusChange);
					System.out.println(applicationEdited);
					System.out.println("Inside nested edit and save appplication");
					
		}		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}
		/*try {
			Application eachApplicationStatusChange=applicationDao.viewEachApplication(applicationid);
			map.addAttribute("eachApplicationStatusChange",eachApplicationStatusChange);
			
		}*/
		catch(Exception e) {
			System.out.println("Inside All Applications List Exception"+e);
		}
		
		
		
			/*return new ModelAndView("changeapplicationstatus","map",map);*/
			
			return new ModelAndView ("redirect:/user/viewallapplications.htm");
	}
	
	
}
