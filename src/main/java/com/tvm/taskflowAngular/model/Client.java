package com.tvm.taskflowAngular.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Client implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(generator="clientId")
//	@GenericGenerator(name = "clientId", 
//			parameters = @Parameter(name="prefix",value="CID"),
//			strategy = "com.tvm.taskflowAngular.model.GenericGenerator.MyGenerator")
	private Integer clientid;
	private String clientName;
	@Embedded
	private Address address;
	private String firstName;
	private String lastName;
	private String groupName;
//	@Email(message = "Email must be a valid email address")
	private String email;
	private Integer mobile;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Integer getClientid() {
		return clientid;
	}
	public void setClientid(Integer clientid) {
		this.clientid = clientid;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", clientName=" + clientName + ", address=" + address + ", firstName="
				+ firstName + ", lastName=" + lastName + ", groupName=" + groupName + ", email=" + email + ", mobile="
				+ mobile + "]";
	}
	
	
	public Client(Integer clientid, String clientName, Address address, String firstName, String lastName,
			String groupName, String email, Integer mobile, Date createdAt) {
		super();
		this.clientid = clientid;
		this.clientName = clientName;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.groupName = groupName;
		this.email = email;
		this.mobile = mobile;
		this.createdAt = createdAt;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
