package com.me.myprojectapp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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

	private static final String RESUME_DIR = "/Resume/";

	@RequestMapping(value = "/user/viewalljobs.htm", method = RequestMethod.GET)
	public ModelAndView showViewAllJobsForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			StudentDAO studentDao, Job job, JobDAO jobDao, ModelMap map) {

		try {
			ArrayList<Job> listOfJobs = jobDao.getJobs();
			map.addAttribute("listOfJobs", listOfJobs);
			for (Job eachjob : listOfJobs) {

				System.out.println("Each Job" + eachjob.getEmployer());
			}
		} catch (Exception e) {
			System.out.println("Inside Job List Exception" + e);
		}

		return new ModelAndView("viewalljobs", "map", map);
	}

	@RequestMapping(value = "/user/viewalljobs.htm", method = RequestMethod.POST)
	public ModelAndView showViewJobsForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			StudentDAO studentDao, Job job, JobDAO jobDao, ModelMap map) {

		// HttpSession session = request.getSession();

		String jobid = request.getParameter("job");
		System.out.println(jobid);

		try {
			Job jobDesc = jobDao.viewEachJob(jobid);
			map.addAttribute("jobDesc", jobDesc);

			System.out.println("Each Job" + jobDesc);

		} catch (Exception e) {
			System.out.println("Inside Job List Exception" + e);
		}

		return new ModelAndView("applyjob", "map", map);

	}

	@RequestMapping(value = "/user/viewjobinformation.htm", method = RequestMethod.POST)
	public ModelAndView showViewAllJobsJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			JobDAO jobDao, ModelMap map) {

		// HttpSession session = request.getSession();

		String jobId = request.getParameter("jobid");
		System.out.println(jobId);
		try {
			Job jobDesc = jobDao.viewEachJob(jobId);
			map.addAttribute("jobDesc", jobDesc);

			System.out.println("ABA ABA ABC Job ID is:" + jobId);

		} catch (Exception e) {
			System.out.println("Inside Job List Exception" + e);
		}

		return new ModelAndView("applyjob", "map", map);

	}

	@RequestMapping(value = "/user/viewjobinformation.htm", method = RequestMethod.GET)
	public ModelAndView showJobInformationForm(HttpServletRequest request, UserDAO userDao, StudentDAO studentDao,
			AdminDAO adminDao, JobDAO jobDao, ModelMap map) {

		String jobId = request.getParameter("jobid");
		try {
			Job jobDesc = jobDao.viewEachJob(jobId);
			map.addAttribute("jobDesc", jobDesc);

			System.out.println("Each Job" + jobDesc);

		} catch (Exception e) {
			System.out.println("Inside Job List Exception" + e);
		}

		return new ModelAndView("viewjobinformation", "map", map);
	}

	@RequestMapping(value = "/user/applyjob.htm", method = RequestMethod.GET)
	public ModelAndView showApplyJobForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao, JobDAO jobDao,
			ModelMap map) {

		/*
		 * String job=request.getParameter("job"); System.out.println(job); try { Job
		 * jobDesc=jobDao.viewEachJob(job); map.addAttribute("jobDesc",jobDesc);
		 * 
		 * System.out.println("Each Job"+jobDesc);
		 * 
		 * } catch(Exception e) { System.out.println("Inside Job List Exception"+e); }
		 */

		return new ModelAndView("applyjob", "map", map);
	}

	@RequestMapping(value = "/user/applyjob.htm", method = RequestMethod.POST)
	public ModelAndView showApplySuccessForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			@RequestParam("file") MultipartFile file, StudentDAO studentDao, HandlerDAO handlerDao, JobDAO jobDao,
			ModelMap map, ApplicationsDAO applicationDao) {

		String jobId = request.getParameter("jobid");

		/* Captcha captcha = Captcha.load(request, "CaptchaObject"); */
		// String captchaCode = request.getParameter("captchaCode");
		HttpSession session = request.getSession();
		if (true) {
			/* if (captcha.validate(captchaCode)) { */
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String emailid = request.getParameter("emailid");
			String nuid = request.getParameter("nuid");
			String skills = request.getParameter("skills");
			String experience = request.getParameter("experience");
			String grade = request.getParameter("grade");

			String loggeduser = request.getParameter("emailid");
			String jobdetails = request.getParameter("jobid");

			System.out.println("QWERTY" + jobdetails);

			User loggeduserobject = handlerDao.getLoggedUser(loggeduser);
			Job jobdetailsobject = handlerDao.getLoggedJob(jobdetails);

			System.out.println("QWERTYQWERTY" + jobdetailsobject);

			System.out.println("ABAABCABC");
			System.out.println("ABCABCABC" + loggeduser);

			Application application = new Application();
			application.setFirstname(firstname);
			application.setLastname(lastname);
			application.setEmailid(emailid);
			application.setNuid(nuid);
			application.setSkills(skills);
			application.setExperience(experience);
			application.setGrade(grade);
			application.setAppstatus("pending");

			application.setUser(loggeduserobject);

			application.setJob(jobdetailsobject);

			try {

				Application a = applicationDao.createApplication(application);

				System.out.println(a.getApplicationid());

				saveFile(file, String.valueOf(a.getApplicationid()));

				System.out.println(a);
				System.out.println("Helllllllllllllllooooooooooooo JOb" + a);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// map.addAttribute("errorMessage", "Invalid Captcha!");
			return new ModelAndView("applyjob");
		}

		return new ModelAndView("redirect:/user/applysuccess.htm");

	}

	@RequestMapping(value = "/user/resume.pdf", method = RequestMethod.GET, produces="application/pdf ")
	public @ResponseBody byte[] getImageWithMediaType(HttpServletRequest request) throws IOException {
		/*
		 * File file = new File(System.getProperty(�user.dir�) + RESUME_DIR +
		 * �resumeAnubhav�);
		 */

		String applicationId = request.getParameter("applicationid");

		Path path = Paths.get(System.getProperty("user.dir") + RESUME_DIR + "resume_" + applicationId + ".pdf");
		return Files.readAllBytes(path);

		/*
		 * InputStream is = new FileInputStream(file); if (is != null) { return
		 * Io.toByteArray(is); }
		 * 
		 * ClassPathResource imageFile = new
		 * ClassPathResource(�static/images/default-placeholder.png�); return
		 * IOUtils.toByteArray(imageFile.getInputStream());
		 */

	}

	@RequestMapping(value = "/user/applysuccess.htm", method = RequestMethod.GET)
	public ModelAndView showApplySuccessSucessForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			JobDAO jobDao, ModelMap map) {

		/*
		 * String jobId=request.getParameter("jobid"); try { Job
		 * jobDesc=jobDao.viewEachJob(jobId); map.addAttribute("jobDesc",jobDesc);
		 * 
		 * System.out.println("Each Job"+jobDesc);
		 * 
		 * } catch(Exception e) { System.out.println("Inside Job List Exception"+e); }
		 */

		return new ModelAndView("applysuccess");
	}

	@RequestMapping(value = "/user/myapplications.htm", method = RequestMethod.GET)
	public ModelAndView showMyApplicationsForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			ApplicationsDAO applicationDao, StudentDAO studentDao, Job job, JobDAO jobDao, ModelMap map) {

		String studentid = request.getParameter("userid");

		System.out.println("SSSSSSSSSSSSS" + studentid);

		try {
			ArrayList<Application> listOfApplications = applicationDao.getApplications(studentid);
			map.addAttribute("listOfApplications", listOfApplications);
			for (Application eachApplication : listOfApplications) {

				System.out.println("Each Applicationnnnnnnnnnn" + eachApplication.getSkills());
			}
		} catch (Exception e) {
			System.out.println("Inside Job List Exception" + e);
		}

		return new ModelAndView("myapplications", "map", map);
	}

	@RequestMapping(value = "/user/myapplications.htm", method = RequestMethod.POST)
	public ModelAndView myApplicationStatusForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			StudentDAO studentDao, ApplicationsDAO applicationDao, Job job, JobDAO jobDao, ModelMap map) {

		// HttpSession session = request.getSession();

		String applicationid = request.getParameter("applicationid");
		System.out.println(applicationid);

		try {
			Application applicationDesc = applicationDao.viewEachApplication(applicationid);
			map.addAttribute("applicationDesc", applicationDesc);

			System.out.println("Each Application" + applicationDesc);

		} catch (Exception e) {
			System.out.println("Inside Application List Exception" + e);
		}

		return new ModelAndView("viewapplicationstatus", "map", map);

	}

	@RequestMapping(value = "/user/printapplication.htm", method = RequestMethod.GET)
	public ModelAndView printApplicationForm(HttpServletRequest request, UserDAO userDao,
			ApplicationsDAO applicationDao, AdminDAO adminDao, JobDAO jobDao, ModelMap map) {

		// HttpSession session = request.getSession();

		String applicationid = request.getParameter("applicationid");
		System.out.println(applicationid);

		try {
			Application applicationDesc = applicationDao.viewEachApplication(applicationid);
			map.addAttribute("applicationDesc", applicationDesc);

			System.out.println("Each Application" + applicationDesc);

		} catch (Exception e) {
			System.out.println("Inside Application List Exception" + e);
		}

		return new ModelAndView("printapplication", "map", map);
	}

	/*
	 * -------------------------------------------- Search Job Using AJAX
	 * --------------------------------------------------------
	 */

	@RequestMapping(value = "/user/searchjob.htm", method = RequestMethod.POST)
	public @ResponseBody ArrayList<Job> printSearchJobForm(HttpServletRequest request, UserDAO userDao,
			ApplicationsDAO applicationDao, AdminDAO adminDao, JobDAO jobDao, ModelMap map) {

		// HttpSession session = request.getSession();

		String searchjob = request.getParameter("searchjob");
		System.out.println(searchjob);

		try {
			ArrayList<Job> getAllJobs = jobDao.getJobs();
			// ArrayList<Job> searchJobByName=jobDao.searchJob(searchjob);
			// return map.addAttribute("searchJobByName",searchJobByName);

			if (searchjob == null || searchjob.isEmpty()) {
				return getAllJobs;
			}

			ArrayList<Job> searchJobByName = new ArrayList<Job>();

			for (Job job : getAllJobs) {

				if (job.getJobtitle().matches(searchjob)) {
					searchJobByName.add(job);
				}
			}

			return searchJobByName;

		} catch (Exception e) {
			System.out.println("Inside Search Job Exception" + e);
		}

		return null;

	}

	/*
	 * -----------------------------------------------------------------------------
	 * -------------------------------------
	 */

	/*
	 * -----------------------------------------------------------------------------
	 * -------------------------------------
	 */

	@RequestMapping(value = "/user/upload.htm", method = RequestMethod.POST)

	// If not @RestController, uncomment this
	@ResponseBody
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

		if (file.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		// Get the file and save it somewhere

		String resumeDir = System.getProperty("user.dir") + RESUME_DIR;
		System.out.println(resumeDir);

		if (!Files.exists(Paths.get(resumeDir))) {

			new File(resumeDir).mkdir();

		}

		File tempFile = new File(resumeDir + "Resume_");

		try {
			file.transferTo(tempFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Path path = Paths.get(resumeDir + file.getOriginalFilename());
		 * Files.write(path, bytes);
		 * 
		 * redirectAttributes.addFlashAttribute(�message�, �You successfully uploaded ��
		 * + file.getOriginalFilename() + ���);
		 */

		return new ResponseEntity("Successfully uploaded - " + file.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	/*
	 * -----------------------------------------------------------------------------
	 * -------------------------------------
	 */

	@RequestMapping(value = "/user/checkapplicationstatus.htm", method = RequestMethod.POST)
	public ModelAndView showChangeApplicationStatusForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			ApplicationsDAO applicationDao, StudentDAO studentDao, Job job, JobDAO jobDao, ModelMap map) {

		System.out.println("Inside Change Appication Status POST Controller");

		String applicationid = request.getParameter("applicationid");
		System.out.println("Change App Status POST Application id:" + applicationid);
		System.out.println(applicationid);

		/*
		 * String appstatus=request.getParameter("appstatus");
		 */

		try {
			Application viewApplicationStatus = applicationDao.viewEachApplication(applicationid);
			map.addAttribute("viewApplicationStatus", viewApplicationStatus);

		} catch (Exception e) {
			System.out.println("Inside All Applications List Exception" + e);
		}

		return new ModelAndView("checkapplicationstatus", "map", map);
	}

	@RequestMapping(value = "/user/printform.pdf", method = RequestMethod.GET)
	public ModelAndView showPrintForm(HttpServletRequest request, UserDAO userDao, AdminDAO adminDao,
			ApplicationsDAO applicationDao, StudentDAO studentDao, Job job, JobDAO jobDao, ModelMap map) {

		String applicationid = request.getParameter("applicationid");
		/* String applicationid = "1"; */

		System.out.println(applicationid);

		/*
		 * String appstatus=request.getParameter("appstatus");
		 * 
		 * 
		 */

		Application viewApplicationStatus = null;

		try {
			viewApplicationStatus = applicationDao.viewEachApplication(applicationid);
			map.addAttribute("viewApplicationStatus", viewApplicationStatus);
			System.out.println("Aplicationnnnnnnnnnnnnnnnnnnnnnnnnnnnn"+viewApplicationStatus.getApplicationid());

		} catch (Exception e) {
			System.out.println("Inside All Applications List Exception" + e);
		}

		return new ModelAndView("pdfView", "application", viewApplicationStatus);

	}

	public void saveFile(MultipartFile file, String applicationId) {

		if (file == null || file.isEmpty()) {
			return;
		}

		// Get the file and save it somewhere

		String resumeDir = System.getProperty("user.dir") + RESUME_DIR;
		System.out.println(resumeDir);

		if (!Files.exists(Paths.get(resumeDir))) {

			new File(resumeDir).mkdir();

		}

		File tempFile = new File(resumeDir + "Resume_" + applicationId + ".pdf");

		try {
			file.transferTo(tempFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
