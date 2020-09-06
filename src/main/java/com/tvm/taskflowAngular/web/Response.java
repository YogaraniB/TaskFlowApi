package com.tvm.taskflowAngular.web;



import org.springframework.http.HttpStatus;




public class Response {
	private String message;
	private boolean status;
	public Response(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
