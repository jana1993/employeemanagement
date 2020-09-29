package com.cognizant.employee.exception;

public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1;
	
	public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
