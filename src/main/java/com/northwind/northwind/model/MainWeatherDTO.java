package com.northwind.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainWeatherDTO {
	@JsonProperty("temp")
    private Double temp;
	@JsonProperty("feels_like")
    private Double feelsLike;
	@JsonProperty("temp_min")
    private Double tempMin;
	@JsonProperty("temp_max")
    private Double tempMax;
	@JsonProperty("pressure")
    private Integer pressure;
	@JsonProperty("sea_level")
    private Integer seaLevel;
	@JsonProperty("grnd_level")
    private Integer grndLevel;
	@JsonProperty("humidity")
    private Integer humidity;
	@JsonProperty("temp_kf")
    private Double  tempKf;
	
	public Double getTempKf() {
		return tempKf;
	}
	public void setTempKf(Double tempKf) {
		this.tempKf = tempKf;
	}
	public Double getTemp() {
		return temp;
	}
	public void setTemp(Double temp) {
		this.temp = temp;
	}
	public Double getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(Double feelsLike) {
		this.feelsLike = feelsLike;
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
	public Integer getPressure() {
		return pressure;
	}
	public void setPressure(Integer pressure) {
		this.pressure = pressure;
	}
	public Integer getSeaLevel() {
		return seaLevel;
	}
	public void setSeaLevel(Integer seaLevel) {
		this.seaLevel = seaLevel;
	}
	public Integer getGrndLevel() {
		return grndLevel;
	}
	public void setGrndLevel(Integer grndLevel) {
		this.grndLevel = grndLevel;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	
	
	@Override
	public String toString() {
		return "MainWeatherDTO [temp=" + temp + ", feelsLike=" + feelsLike + ", tempMin=" + tempMin + ", tempMax="
				+ tempMax + ", pressure=" + pressure + ", seaLevel=" + seaLevel + ", grndLevel=" + grndLevel
				+ ", humidity=" + humidity + ", tempKf=" + tempKf + "]";
	}
	
	
}
