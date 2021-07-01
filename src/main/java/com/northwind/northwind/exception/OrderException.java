package com.northwind.northwind.exception;

public class OrderException extends Exception {
	private static final long serialVersionUID = 482809499846632997L;

	public OrderException() {
		super("Errore");
	}
	
	public OrderException(String message) {
		super(message);
	}
}
