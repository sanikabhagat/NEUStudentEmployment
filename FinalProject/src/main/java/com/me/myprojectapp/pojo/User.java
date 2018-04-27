package com.me.myprojectapp.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Inheritance;

@Entity
@Table(name = "user_table")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	private long userid;
	private String emailid;
	private String password;
	private int status;
	private String role;
	
	private Collection<Application> application=new ArrayList<Application>();

	private Collection<Job> jobs=new ArrayList<Job>();	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	
	@NotEmpty(message = "Please enter your username.")
	@Column(name = "emailid", unique = true, nullable = false)
	public String getEmailid() {
		return emailid;
	}

	

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "password")
	@Size(min = 6 , max = 15)
	@NotEmpty(message = "Please enter your password.")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy="user",cascade=CascadeType.PERSIST)
	public Collection<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Collection<Job> jobs) {
		this.jobs = jobs;
	}

	
	@OneToMany(mappedBy="user",cascade=CascadeType.PERSIST)
	public Collection<Application> getApplication() {
		return application;
	}

	
	public void setApplication(Collection<Application> application) {
		this.application = application;
	}

	
	@Column(name = "role")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	

}
