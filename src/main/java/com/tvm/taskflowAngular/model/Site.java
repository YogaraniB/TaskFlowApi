package com.tvm.taskflowAngular.model;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Site {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer siteId;

	private String client;
	private String region;
	private String branch;
	private String email;
	private String siteName;
	@Embedded
	private Address address;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
	
	
	
	



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Site(Integer siteId, String client, String region, String branch, String email, String siteName,
			Address address, Date createdAt) {
		super();
		this.siteId = siteId;
		this.client = client;
		this.region = region;
		this.branch = branch;
		this.email = email;
		this.siteName = siteName;
		this.address = address;
		this.createdAt = createdAt;
	}



	public Integer getSiteId() {
		return siteId;
	}



	public void setSiteId(Integer siteId) {
		this.siteId = siteId;
	}



	public String getClient() {
		return client;
	}



	public void setClient(String client) {
		this.client = client;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSiteName() {
		return siteName;
	}



	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
