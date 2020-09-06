package com.tvm.taskflowAngular.web;

import java.util.List;

public class ResponseAPI {
	private String message;
	private boolean status;
	private List<?> list;
	private int recordCount;
	
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public ResponseAPI(String message, boolean status, List<?> list, int recordCount) {
		super();
		this.message = message;
		this.status = status;
		this.list = list;
		this.recordCount = recordCount;
	}
	public ResponseAPI() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ResponseAPI(String message) {
		super();
		this.message = message;
	}
	public ResponseAPI(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
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
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	
	
}
