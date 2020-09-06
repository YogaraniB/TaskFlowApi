package com.tvm.taskflowAngular.web;



import java.util.Date;
//u can customize this class as per ur requirment? bean!
public class ErrorMessage {

	private Date date;
	private String message;
	private String toContact;
	private String details;
	
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getToContact() {
		return toContact;
	}
	public void setToContact(String toContact) {
		this.toContact = toContact;
	}
	public ErrorMessage(Date date, String message, String toContact) {
		super();
		this.date = date;
		this.message = message;
		this.toContact = toContact;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(Date date, String message, String toContact,
			String details) {
		super();
		this.date = date;
		this.message = message;
		this.toContact = toContact;
		this.details = details;
	}
	
	
	
}
