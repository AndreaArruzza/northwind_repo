package com.northwind.northwind.resource;

import java.time.LocalDate;

public class WeatherResource {
	
	private LocalDate data;
	private Double temperatura;
	private String descrTemperatura;
	
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public Double getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	public String getDescrTemperatura() {
		return descrTemperatura;
	}
	public void setDescrTemperatura(String descrTemperatura) {
		this.descrTemperatura = descrTemperatura;
	}
	
	
	
}
