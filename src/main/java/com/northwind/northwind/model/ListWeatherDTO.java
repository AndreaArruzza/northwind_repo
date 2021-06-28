package com.northwind.northwind.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListWeatherDTO {
	@JsonProperty("dt")
	private String data;
	@JsonProperty("dt_txt")
	private String dateTxt;
	@JsonProperty("visibility")
	private String visibility;
	@JsonProperty("pop")
	private Double pop;
	@JsonProperty("main")
	private MainWeatherDTO mainWeather;
	@JsonProperty("weather")
	private List<WeatherDTO> weather;
	@JsonProperty("clouds")
	private CloudDTO clouds;
	@JsonProperty("wind")
	private WindDTO wind;
	@JsonProperty("rain")
	private RainDTO rain;
	@JsonProperty("snow")
	private SnowDTO snow;
	@JsonProperty("sys")
	private DayDTO pod;
	
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

	public MainWeatherDTO getMainWeather() {
		return mainWeather;
	}

	public void setMainWeather(MainWeatherDTO mainWeather) {
		this.mainWeather = mainWeather;
	}

	public  List<WeatherDTO> getWeather() {
		return weather;
	}

	public void setWeather( List<WeatherDTO> weather) {
		this.weather = weather;
	}

	public CloudDTO getClouds() {
		return clouds;
	}

	public void setClouds(CloudDTO clouds) {
		this.clouds = clouds;
	}

	public WindDTO getWind() {
		return wind;
	}

	public void setWind(WindDTO wind) {
		this.wind = wind;
	}

	public RainDTO getRain() {
		return rain;
	}

	public void setRain(RainDTO rain) {
		this.rain = rain;
	}

	public SnowDTO getSnow() {
		return snow;
	}

	public void setSnow(SnowDTO snow) {
		this.snow = snow;
	}

	public DayDTO getPod() {
		return pod;
	}

	public void setPod(DayDTO pod) {
		this.pod = pod;
	}

	@Override
	public String toString() {
		return "ListWeatherDTO [data=" + data + ", dateTxt=" + dateTxt + ", visibility=" + visibility + ", pop=" + pop
				+ ", mainWeather=" + mainWeather + ", weather=" + weather + ", clouds=" + clouds + ", wind=" + wind
				+ ", rain=" + rain + ", snow=" + snow + ", pod=" + pod + "]";
	}
}
