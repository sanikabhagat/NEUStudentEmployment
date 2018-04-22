package com.me.myprojectapp;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.myprojectapp.dao.AdminDAO;
import com.me.myprojectapp.dao.HandlerDAO;
import com.me.myprojectapp.dao.JobDAO;
import com.me.myprojectapp.dao.StudentDAO;
/*
import com.captcha.botdetect.web.servlet.Captcha;*/
import com.me.myprojectapp.dao.UserDAO;
import com.me.myprojectapp.pojo.Admin;
import com.me.myprojectapp.pojo.Job;
import com.me.myprojectapp.pojo.Student;
import com.me.myprojectapp.pojo.User;
import com.me.myprojectapp.validator.LoginValidator;
import com.me.myprojectapp.validator.UserValidator;


@Controller
public class AuthenticationController {

@Autowired
@Qualifier("userValidator")
UserValidator userValidator;


@Autowired
@Qualifier("loginValidator")
LoginValidator loginValidator;
	
/*	
@RequestMapping(value = "/user/register.htm", method = RequestMethod.GET)
public String showRegisterForm(HttpServletRequest request, User user) {
request.setAttribute("userAttribute", new User());
	return "register";
}*/

/*@RequestMapping(value = "/user/register.htm", method = RequestMethod.POST)
public ModelAndView handleRegisterForm(HttpServletRequest request, UserDAO userDao, ModelMap map, @ModelAttribute("userAttribute") User user, BindingResult bindingResult) {
userValidator.validate(user, bindingResult);
	if (bindingResult.hasErrors())
	{
		
		return new ModelAndView("register","user",user); 
	}
	Captcha captcha = Captcha.load(request, "CaptchaObject");
	//String captchaCode = request.getParameter("captchaCode");
	HttpSession session = request.getSession();
	if(true) {
	if (captcha.validate(captchaCode)) {
		String useremail = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("firstname");
		Long nuid=Long.parseLong(request.getParameter("nuid"));
		String program=request.getParameter("program");
		user = new User();
		user.setEmailid(useremail);
		user.setPassword(password);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setNuid(nuid);
		user.setProgram(program); 
		user.setStatus(0);

		try {
			User u = userDao.register(user);
			Random rand = new Random();
			int randomNum1 = rand.nextInt(5000000);
			int randomNum2 = rand.nextInt(5000000);
			try {
				String str = "http://localhost:8080/myprojectapp/user/validateuser.htm?email=" + user.getEmailid() + "&key1="
						+ randomNum1 + "&key2=" + randomNum2;
				session.setAttribute("key1", randomNum1);
				session.setAttribute("key2", randomNum2);
				sendEmail(user.getEmailid(),
						"Click on this link to activate your account : "+ str);
			} catch (Exception e) {
				System.out.println("Email cannot be sent");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		map.addAttribute("errorMessage", "Invalid Captcha!");
		return new ModelAndView ("register");
	}

	return new ModelAndView("register-successful");
}*/

/* --------------- Admin Registration ------------------*/

@RequestMapping(value = "/user/adminregister.htm", method = RequestMethod.GET)
public String adminRegisterForm() {
		
	return "adminregister";
}



@RequestMapping(value = "/user/adminregister.htm", method = RequestMethod.POST)
public ModelAndView handleAdminRegisterForm(HttpServletRequest request, AdminDAO adminDao, UserDAO userDao, ModelMap map) {

	/*Captcha captcha = Captcha.load(request, "CaptchaObject");*/
	//String captchaCode = request.getParameter("captchaCode");
	HttpSession session = request.getSession();
	if(true) {
/*	if (captcha.validate(captchaCode)) {*/
		String useremail = request.getParameter("emailid");
		String password = request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		Long employeeid=Long.parseLong(request.getParameter("employeeid"));
		Admin admin = new Admin();
		admin.setEmailid(useremail);
		admin.setPassword(password);
		admin.setFirstname(firstname);
		admin.setLastname(lastname);
		admin.setEmployeeid(employeeid);
		admin.setStatus(0);

		try {
			Admin a = adminDao.register(admin);
			System.out.println("Helllllllllllllllooooooooooooo"+a);
			Random rand = new Random();
			int randomNum1 = rand.nextInt(5000000);
			int randomNum2 = rand.nextInt(5000000);
			try {
				String str = "http://localhost:8080/myprojectapp/user/validateuser.htm?email=" + a.getEmailid() + "&key1="
						+ randomNum1 + "&key2=" + randomNum2;
				session.setAttribute("key1", randomNum1);
				session.setAttribute("key2", randomNum2);
				sendEmail(a.getEmailid(),
						"Click on this link to activate your account : "+ str);
			} catch (Exception e) {
				System.out.println("Email cannot be sent");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		map.addAttribute("errorMessage", "Invalid Captcha!");
		return new ModelAndView ("studentregister");
	}

	return new ModelAndView("register-successful");
}


/* ---------------------------------------------------*/
public void sendEmail(String useremail, String message) {
	try {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("contactapplication2018@gmail.com", "springmvc"));
		email.setSSLOnConnect(true);
		email.setFrom("no-reply@msis.neu.edu"); // This user email does not
												// exist
		email.setSubject("Password Reminder");
		email.setMsg(message); // Retrieve email from the DAO and send this
		email.addTo(useremail);
		email.send();
	} catch (EmailException e) {
		System.out.println("Email cannot be sent");
	}
}


@RequestMapping(value = "/user/validateuser.htm", method = RequestMethod.GET)
public String showValidateUser(HttpServletRequest request, UserDAO userDao, ModelMap map) {
	
	String email=request.getParameter("email");
	/*String key1=request.getParameter("key1");
	String key2=request.getParameter("key2");*/
	
	
	try {
		User user = userDao.validateUser(email);	
		System.out.println(user);
		
		user.setStatus(1);
		
	user=userDao.register(user);
	System.out.println(user);	
	}
	catch(Exception e) {
		
	}

	return "validateuser";
}


@RequestMapping(value = "/user/userdashboard.htm", method = RequestMethod.GET)
public ModelAndView showUserDashboardForm(HttpServletRequest request, User user) {

	
	HttpSession session=request.getSession();
	System.out.println(session);
	if(session.getAttribute("user")==null)
	{
		return new ModelAndView("redirect:/user/login.htm");
	}
	else {
		return new ModelAndView("userdashboard");
	}
	
}


@RequestMapping(value = "/user/admindashboard.htm", method = RequestMethod.GET)
public ModelAndView showAdminDashboardForm(HttpServletRequest request, User user) {

	
	HttpSession session=request.getSession();
	System.out.println(session);
	if(session.getAttribute("user")==null)
	{
		return new ModelAndView("redirect:/user/login.htm");
	}
	else {
		return new ModelAndView("admindashboard");
	}
	
}




@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
public String showLoginForm(/*HttpServletRequest request,User user*/) {
		/*request.setAttribute("loginAttribute", user);*/
	
	return "login";
}

@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
public ModelAndView handleLoginForm(HttpServletRequest request, UserDAO userDao, StudentDAO studentDao, 
		ModelMap map/*, @ModelAttribute("loginAttribute") User user, BindingResult bindingResult*/) {
	
		/*loginValidator.validate(user, bindingResult);
			if (bindingResult.hasErrors())
			{
				System.out.println("Going inside login validator");
				return new ModelAndView("login","user",user); 
			}*/

	HttpSession session = request.getSession();
	
	
	String role=request.getParameter("role");
	String emailid = request.getParameter("emailid");
	String password = request.getParameter("password");
if(role.equals("Student")) {
	try {
		User u = userDao.loginUser(emailid, password);

		if (u != null && u.getStatus() == 1) {
			session.setAttribute("user", u);
			map.addAttribute("user", u);
			return new ModelAndView("redirect:/user/userdashboard.htm",map);
		} else if (u != null && u.getStatus() == 0) {
			map.addAttribute("errorMessage", "Please activate your account to login!");
			return new ModelAndView("error",map);
		} else {
			map.addAttribute("errorMessage", "Invalid username/password!");
			return new ModelAndView("error",map);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

if(role.equals("Admin")) {
	try {
		User u = userDao.loginUser(emailid, password);

		if (u != null && u.getStatus() == 1) {
			session.setAttribute("user", u);
			map.addAttribute("user", u);
			return new ModelAndView("redirect:/user/admindashboard.htm",map);
		} else if (u != null && u.getStatus() == 0) {
			map.addAttribute("errorMessage", "Please activate your account to login!");
			return new ModelAndView("error",map);
		} else {
			map.addAttribute("errorMessage", "Invalid username/password!");
			return new ModelAndView("error",map);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	return new ModelAndView("home",map);

}

@RequestMapping(value = "/user/logout.htm", method = RequestMethod.GET)
public String showLogoutForm(HttpServletRequest request) {
		
	HttpSession session=request.getSession();
	
	session.invalidate();
	
	return "logout";
}


@RequestMapping(value = "/user/myapplications.htm", method = RequestMethod.GET)
public String showMyApplicationsForm() {
		
	return "myapplications";
}


@RequestMapping(value = "/user/mydetails.htm", method = RequestMethod.GET)
public String showMyDetailsForm() {
	
	
	return "mydetails";
}


@RequestMapping(value = "/user/findjob.htm", method = RequestMethod.GET)
public String showFindJobForm() {
		
	return "findjob";
}

@RequestMapping(value = "/user/registeras.htm", method = RequestMethod.GET)
public String showRegisterAsForm() {
		
	return "registeras";
}


@RequestMapping(value = "/user/studentregister.htm", method = RequestMethod.GET)
public String showStudentRegisterForm() {

	return "studentregister";
}




@RequestMapping(value = "/user/studentregister.htm", method = RequestMethod.POST)
public ModelAndView handleRegisterForm(HttpServletRequest request, StudentDAO studentDao, ModelMap map) {

	/*Captcha captcha = Captcha.load(request, "CaptchaObject");*/
	//String captchaCode = request.getParameter("captchaCode");
	HttpSession session = request.getSession();
	if(true) {
/*	if (captcha.validate(captchaCode)) {*/
		String useremail = request.getParameter("emailid");
		String password = request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		Long nuid=Long.parseLong(request.getParameter("nuid"));
		String program=request.getParameter("program");
		Student student = new Student();
		student.setEmailid(useremail);
		student.setPassword(password);
		student.setFirstname(firstname);
		student.setLastname(lastname);
		student.setNuid(nuid);
		student.setProgram(program); 
		student.setStatus(0);

		try {
			Student s = studentDao.register(student);
			System.out.println("Helllllllllllllllooooooooooooo"+s);
			Random rand = new Random();
			int randomNum1 = rand.nextInt(5000000);
			int randomNum2 = rand.nextInt(5000000);
			try {
				String str = "http://localhost:8080/myprojectapp/user/validateuser.htm?email=" + s.getEmailid() + "&key1="
						+ randomNum1 + "&key2=" + randomNum2;
				session.setAttribute("key1", randomNum1);
				session.setAttribute("key2", randomNum2);
				sendEmail(s.getEmailid(),
						"Click on this link to activate your account : "+ str);
			} catch (Exception e) {
				System.out.println("Email cannot be sent");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		map.addAttribute("errorMessage", "Invalid Captcha!");
		return new ModelAndView ("studentregister");
	}

	return new ModelAndView("register-successful");
}


/*-----------------------Create Job Get And Post Methods---------------------*/


@RequestMapping(value = "/user/createjob.htm", method = RequestMethod.GET)
public String showCreateJobForm() {

	return "createjob";
}



@RequestMapping(value = "/user/createjob.htm", method = RequestMethod.POST)
public ModelAndView handleCreateJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,JobDAO jobDao, ModelMap map, HandlerDAO handlerDao) {

	/*Captcha captcha = Captcha.load(request, "CaptchaObject");*/
	//String captchaCode = request.getParameter("captchaCode");
	HttpSession session = request.getSession();
	if(true) {
	/*if (captcha.validate(captchaCode)) {*/
		String jobid = request.getParameter("jobid");
		String jobtitle = request.getParameter("jobtitle");
		String employer=request.getParameter("employer");
		String category=request.getParameter("category");
		String wage=request.getParameter("wage");
		String openings=request.getParameter("openings");
		String loggedadmin=request.getParameter("loggedadmin");
		
		User loggeduserobject=handlerDao.getLoggedUser(loggedadmin);
		
		System.out.println("Testing Admin Object");
		System.out.println("Admin Object is"+loggedadmin);
		
		Job job = new Job();
		job.setJobid(jobid);
		job.setJobtitle(jobtitle);
		job.setEmployer(employer);
		job.setCategory(category);
		job.setWage(wage);
		job.setOpenings(openings); 
		job.setUser(loggeduserobject);
		
		try {
			Job j=jobDao.createJob(job);
			System.out.println(j);
			System.out.println("Helllllllllllllllooooooooooooo JOb"+j);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		//map.addAttribute("errorMessage", "Invalid Captcha!");
		return new ModelAndView ("createjob");
	}

	return new ModelAndView("redirect:/user/joblist.htm");
	
	
}


/*------------------------------------------------------------------*/

@RequestMapping(value = "/user/joblist.htm", method = RequestMethod.GET)
public ModelAndView showJobListForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, Job job, JobDAO jobDao,ModelMap map) {
	

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
	
	
	
	return new ModelAndView("joblist","map",map);
}


@RequestMapping(value = "/user/joblist.htm", method = RequestMethod.POST)
public ModelAndView handleDeleteJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,JobDAO jobDao, ModelMap map) {

	//HttpSession session = request.getSession();
	
		String jobid = request.getParameter("jobid");
		System.out.println(jobid);
		
		try {
			int result= jobDao.deleteJob(jobid);
			
		if(result!=0) {
			return new ModelAndView ("redirect:/user/joblist.htm");
		}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	return new ModelAndView("redirect:/user/joblist.htm");
	
	
}


/* ----------------------Edit Job Get and Post Methods------------------------------- */

@RequestMapping(value = "/user/editjob.htm", method = RequestMethod.GET)
public ModelAndView showEditJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, JobDAO jobDao,ModelMap map) {
	
	String jobId=request.getParameter("jobid");
	try {
		Job jobEdit=jobDao.getJobToEdit(jobId);
		map.addAttribute("jobToEdit",jobEdit);
		
			System.out.println("Each Job"+jobEdit);
	
	}
	catch(Exception e) {
		System.out.println("Inside Job List Exception"+e);
	}
	
	return new ModelAndView("editjob","map",map);
}



@RequestMapping(value = "/user/editjob.htm", method = RequestMethod.POST)
public ModelAndView handleEditInputJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,JobDAO jobDao, ModelMap map) {

	//HttpSession session = request.getSession();
	if(true) {
	/*if (captcha.validate(captchaCode)) {*/
		String jobid = request.getParameter("jobid");
		String jobtitle = request.getParameter("jobtitle");
		String employer=request.getParameter("employer");
		String category=request.getParameter("category");
		String wage=request.getParameter("wage");
		String openings=request.getParameter("openings");
		
		
		try {
			Job job = jobDao.getJobToEdit(jobid);
			
			job.setJobid(jobid);
			job.setJobtitle(jobtitle);
			job.setEmployer(employer);
			job.setCategory(category);
			job.setWage(wage);
			job.setOpenings(openings); 
			
			System.out.println(job.toString());
			System.out.println("Inside Edit and Save Job");
			
			
	try {
				Job jobEdited=jobDao.editAndSaveJob(job);
				System.out.println(jobEdited);
				System.out.println("Inside nested edit and save job");
				
	}		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	} else {
		//map.addAttribute("errorMessage", "Invalid Captcha!");
		return new ModelAndView ("editjob");
	}

	return new ModelAndView("redirect:/user/joblist.htm");
	
	
}


/* ------------------------------------------------------------------------------------ */


}