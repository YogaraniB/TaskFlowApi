package com.tvm.taskflowAngular.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Tickets {

	@Id
	private Integer ticketId;
	private String employee;
	private String severity;
	private String assignee;
	private String description;
	private String reportee;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
		
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	
	
	public Tickets(Integer ticketId, String employee, String severity, String assignee, String description,
			String reportee, Date createdAt) {
		super();
		this.ticketId = ticketId;
		this.employee = employee;
		this.severity = severity;
		this.assignee = assignee;
		this.description = description;
		this.reportee = reportee;
		this.createdAt = createdAt;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReportee() {
		return reportee;
	}
	public void setReportee(String reportee) {
		this.reportee = reportee;
	}
	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
