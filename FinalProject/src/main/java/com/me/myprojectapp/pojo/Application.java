package com.me.myprojectapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications_table")
public class Application {
 
	
	private Long applicationid;
	private String firstname;
	private String lastname;
	private String emailid;
	private String nuid;
	private String grade;
	private String experience;
	private String skills;
	private String resume;
	private String appstatus;
	
	private Job job;
	private User user;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "applicationid", unique = true, nullable = false)
	public Long getApplicationid() {
		return applicationid;
	}


	public void setApplicationid(Long applicationid) {
		this.applicationid = applicationid;
	}

	@Column(name = "grade", nullable = false)
	public String getGrade() {
		return grade;
	}
	
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Column(name = "experience", nullable = true)
	public String getExperience() {
		return experience;
	}
	
	
	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	@Column(name = "skills", nullable = true)
	public String getSkills() {
		return skills;
	}
	
	
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	@ManyToOne
	@JoinColumn(name="jobid")
	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne
	@JoinColumn(name="studentid")
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "firstname", nullable = true)
	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = true)
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "emailid", nullable = true)
	public String getEmailid() {
		return emailid;
	}


	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "nuid", nullable = true)
	public String getNuid() {
		return nuid;
	}


	public void setNuid(String nuid) {
		this.nuid = nuid;
	}

	@Column(name = "resume", nullable = true)
	public String getResume() {
		return resume;
	}


	public void setResume(String resume) {
		this.resume = resume;
	}

	@Column(name = "appstatus")
	public String getAppstatus() {
		return appstatus;
	}


	public void setAppstatus(String appstatus) {
		this.appstatus = appstatus;
	}
	
	
	
	
	
	
}
