package com.tvm.taskflowAngular.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity

public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer empid;
	private String firstName;
	private String lastName;
	private Integer mobile;
//	@Email(message = "Email must be a valid email address")
	private String email;
	private String designation;
	 private String password;
	private String client;
	private String fullName;
	private String site;
	private String userRole;

	private String block;
	private String floor;
	private String zone;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Employee(Integer empid, String firstName, String lastName, Integer mobile, String email, String designation,
			String client, String site, String userRole, String block, String floor, String zone, Date createdAt) {
		super();
		this.empid = empid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.designation = designation;
		this.client = client;
		this.site = site;
		this.userRole = userRole;
		this.block = block;
		this.floor = floor;
		this.zone = zone;
		this.createdAt = createdAt;
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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@PostLoad
	public void postLoad() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getCredentials()+"\n" +auth.getName()+"\n" +auth.getAuthorities() +"\n" +auth.getDetails() +"\n" +auth.getPrincipal());
	}
	@PrePersist
	public void prePersist() {
		fullName=firstName.concat(lastName);
	}
	
}
