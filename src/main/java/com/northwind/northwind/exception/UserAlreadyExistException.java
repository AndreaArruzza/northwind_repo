package com.northwind.northwind.exception;

public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = -2536283663357372685L;

	public UserAlreadyExistException() {
		super();
	}
	
	public UserAlreadyExistException(String message) {
		super(message);
	}
}