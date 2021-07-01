package com.northwind.northwind.exception;

public class UsersException extends Exception {
	
	private static final long serialVersionUID = -1016843150804180574L;

	public UsersException() {
		super("Errore");
	}
	
	public UsersException(String message) {
		super(message);
	}
}
