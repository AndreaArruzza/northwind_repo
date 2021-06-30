package com.northwind.northwind.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherList {
	@JsonProperty("dt")
	private String data;
	@JsonProperty("dt_txt")
	private String dateTxt;
	@JsonProperty("visibility")
	private String visibility;
	@JsonProperty("pop")
	private Double pop;
	@JsonProperty("main")
	private WeatherMain mainWeather;
	@JsonProperty("weather")
	private List<Weather> weather;
	@JsonProperty("clouds")
	private Cloud clouds;
	@JsonProperty("wind")
	private Wind wind;
	@JsonProperty("rain")
	private Rain rain;
	@JsonProperty("snow")
	private Snow snow;
	@JsonProperty("sys")
	private Day pod;
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDateTxt() {
		return dateTxt;
	}

	public void setDateTxt(String dateTxt) {
		this.dateTxt = dateTxt;
	}

	public String getVisibility() {
		return visibility;
	}

	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	public Double getPop() {
		return pop;
	}

	public void setPop(Double pop) {
		this.pop = pop;
	}

	public WeatherMain getMainWeather() {
		return mainWeather;
	}

	public void setMainWeather(WeatherMain mainWeather) {
		this.mainWeather = mainWeather;
	}

	public  List<Weather> getWeather() {
		return weather;
	}

	public void setWeather( List<Weather> weather) {
		this.weather = weather;
	}

	public Cloud getClouds() {
		return clouds;
	}

	public void setClouds(Cloud clouds) {
		this.clouds = clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	public Snow getSnow() {
		return snow;
	}

	public void setSnow(Snow snow) {
		this.snow = snow;
	}

	public Day getPod() {
		return pod;
	}

	public void setPod(Day pod) {
		this.pod = pod;
	}

	@Override
	public String toString() {
		return "ListWeatherDTO [data=" + data + ", dateTxt=" + dateTxt + ", visibility=" + visibility + ", pop=" + pop
				+ ", mainWeather=" + mainWeather + ", weather=" + weather + ", clouds=" + clouds + ", wind=" + wind
				+ ", rain=" + rain + ", snow=" + snow + ", pod=" + pod + "]";
	}
}
