package com.me.myprojectapp.pojo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "job_table")
public class Job {

	
	private Long jid; //Table id for job
	private String jobtitle;
	private String jobid;
	private String employer;
	private String wage;
	private String category;
	private String openings;
	
	private User user;
	
	private Collection<Application> application=new ArrayList<Application>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="adminid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	//private Admin admin;
	
	
	
	public Job() {
	
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jid", unique = true, nullable = false)
	public Long getJid() {
		return jid;
	}

	
	public void setJid(Long jid) {
		this.jid = jid;
	}

	@Column(name = "jobtitle", nullable = false)
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	
	@Column(name = "jobid", unique = true, nullable = false)
	public String getJobid() {
		return jobid;
	}
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	
	@Column(name = "employer", nullable = false)
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
	@Column(name = "wage", nullable = false)
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	
	@Column(name = "category", nullable = false)
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name = "openings", nullable = false)
	public String getOpenings() {
		return openings;
	}
	public void setOpenings(String openings) {
		this.openings = openings;
	}

	@JsonIgnore
	@OneToMany(mappedBy="job",cascade=CascadeType.PERSIST)
	public Collection<Application> getApplication() {
		return application;
	}

	public void setApplication(Collection<Application> application) {
		this.application = application;
	}


	
	
	
}
