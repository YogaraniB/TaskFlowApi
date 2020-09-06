package com.tvm.taskflowAngular.model;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Jobs {

	
	@Id
	private Integer jobId;
	private String title;
	private String emp;
	private String actualSTime;
	private String actualETime;
	private String category;
	@ElementCollection
	private List<String> checklist ;
	private String schedule;
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
	
	public Jobs(Integer jobId, String title, String emp, String actualSTime, String actualETime, String category,
			List<String> checklist, String schedule, Date createdAt) {
		super();
		this.jobId = jobId;
		this.title = title;
		this.emp = emp;
		this.actualSTime = actualSTime;
		this.actualETime = actualETime;
		this.category = category;
		this.checklist = checklist;
		this.schedule = schedule;
		this.createdAt = createdAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getJobId() {
		return jobId;
	}
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmp() {
		return emp;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	public String getActualSTime() {
		return actualSTime;
	}
	public void setActualSTime(String actualSTime) {
		this.actualSTime = actualSTime;
	}
	public String getActualETime() {
		return actualETime;
	}
	public void setActualETime(String actualETime) {
		this.actualETime = actualETime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getChecklist() {
		return checklist;
	}
	public void setChecklist(List<String> checklist) {
		this.checklist = checklist;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	public Jobs() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", title=" + title + ", emp=" + emp + ", actualSTime=" + actualSTime
				+ ", actualETime=" + actualETime + ", category=" + category + ", checklist=" + checklist + ", schedule="
				+ schedule + "]";
	}
	
	
}
