package com.tvm.taskflowAngular.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;


@Entity
public class ExcelImport implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer empid;
	private String firstName;
	private String lastName;
	private Integer mobile;
//	@Email(message = "Email must be a valid email address")
	private String email;
	private String designation;
	 
	
	
	
	private int totalDays;
	private String month;

	public int getTotalDays() {
		return totalDays;
	}

	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}


	
	

	

	
	
	@Override
	public String toString() {
		return "ExcelImport [empid=" + empid + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile="
				+ mobile + ", email=" + email + ", designation=" + designation + ", totalDays=" + totalDays + ", month="
				+ month + "]";
	}

	public ExcelImport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExcelImport(Integer empid, String firstName, String lastName, Integer mobile, String email,
			String designation, int totalDays, String month) {
		super();
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.designation = designation;
		this.totalDays = totalDays;
		this.month = month;
	}

	

	

}
