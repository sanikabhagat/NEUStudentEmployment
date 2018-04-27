package com.me.myprojectapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "student_table")
@PrimaryKeyJoinColumn(name = "studentid", referencedColumnName = "userid")
public class Student extends User{

	private String firstname;
	private String lastname;
	private long nuid;
	private String program;
	
	
	
	
	@Column(name = "firstname", nullable = false)
	@NotEmpty(message = "Please enter your First Name")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false)
	@NotEmpty(message = "Please enter your Last Name")
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "nuid", unique = true, nullable = false)
	public long getNuid() {
		return nuid;
	}

	public void setNuid(long nuid) {
		this.nuid = nuid;
	}


	@Column(name = "program")
	@NotEmpty(message = "Please enter your Program")
	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}
	

}