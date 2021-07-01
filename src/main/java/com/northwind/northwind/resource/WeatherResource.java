package com.northwind.northwind.resource;

import java.time.LocalDateTime;

public class WeatherResource {
	private LocalDateTime date;
	private Double temp;
	private Double tempMin;
	private Double tempMax;
	private Integer humidity;
	private String descrTemp;
	private String message;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getTempMin() {
		return tempMin;
	}
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}
	public Double getTempMax() {
		return tempMax;
	}
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public String getDescrTemp() {
		return descrTemp;
	}
	public void setDescrTemp(String descrTemp) {
		this.descrTemp = descrTemp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}