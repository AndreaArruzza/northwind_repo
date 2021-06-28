package com.northwind.northwind.exception;

public class OrdersException extends Exception {
	private static final long serialVersionUID = 482809499846632997L;

	public OrdersException() {
		super("Errore durante l'elaborazione del motore!");
	}
	
	public OrdersException(String message) {
		super(message);
	}
}
