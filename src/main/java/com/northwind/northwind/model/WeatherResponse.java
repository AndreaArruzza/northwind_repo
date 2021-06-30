package com.northwind.northwind.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
	@JsonProperty("cod")
	private String cod;
	@JsonProperty("message")
	private String message;
	@JsonProperty("cnt")
	private String cnt;
	@JsonProperty("list")	
	private List<WeatherList> listWeatherDTO;
	@JsonProperty("city")	
	private City city;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public List<WeatherList> getListWeatherDTO() {
		return listWeatherDTO;
	}
	public void setListWeatherDTO(List<WeatherList> listWeatherDTO) {
		this.listWeatherDTO = listWeatherDTO;
	}
	
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "WeatherResponse [cod=" + cod + ", message=" + message + ", cnt=" + cnt + ", listWeatherDTO="
				+ listWeatherDTO + ", city=" + city + "]";
	}

}
