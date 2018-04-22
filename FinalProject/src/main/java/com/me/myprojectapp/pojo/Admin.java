package com.me.myprojectapp.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
@PrimaryKeyJoinColumn(name = "adminid", referencedColumnName = "userid")
public class Admin extends User{

	


		private String firstname;
		private String lastname;
		private long employeeid;
		
		
/*	private Collection<Job> jobs=new ArrayList<Job>();	*/
		
		

		@Column(name = "firstname", nullable = false)
		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		@Column(name = "lastname", nullable = false)
		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		@Column(name = "employeeid", nullable = false)
		public long getEmployeeid() {
			return employeeid;
		}

		public void setEmployeeid(long employeeid) {
			this.employeeid = employeeid;
		}

		
	
}
