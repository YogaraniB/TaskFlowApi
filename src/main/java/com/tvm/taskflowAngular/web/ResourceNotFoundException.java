package com.tvm.taskflowAngular.web;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6208653503836517114L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

	
}
