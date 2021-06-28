package com.northwind.northwind.exception;

public class WeatherException extends Exception  {
	private static final long serialVersionUID = 1L;

	public WeatherException() {
		super("Errore durante l'elaborazione del motore!");
	}
	
	public WeatherException(String message) {
		super(message);
	}

}
