package com.northwind.northwind.model;

import java.time.LocalDate;

public class WeatherDTO {
	
	private LocalDate data;
	private Double temperatura;
	private Double temperaturaPercepita;
	private Double temperaturaMin;
	private Double temparaturaMax;
	private Double umidità;
	private String meteo;
	private String meteoDescr;
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
	public Double getTemperaturaPercepita() {
		return temperaturaPercepita;
	}
	public void setTemperaturaPercepita(Double temperaturaPercepita) {
		this.temperaturaPercepita = temperaturaPercepita;
	}
	public Double getTemperaturaMin() {
		return temperaturaMin;
	}
	public void setTemperaturaMin(Double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}
	public Double getTemparaturaMax() {
		return temparaturaMax;
	}
	public void setTemparaturaMax(Double temparaturaMax) {
		this.temparaturaMax = temparaturaMax;
	}
	public Double getUmidità() {
		return umidità;
	}
	public void setUmidità(Double umidità) {
		this.umidità = umidità;
	}
	public String getMeteo() {
		return meteo;
	}
	public void setMeteo(String meteo) {
		this.meteo = meteo;
	}
	public String getMeteoDescr() {
		return meteoDescr;
	}
	public void setMeteoDescr(String meteoDescr) {
		this.meteoDescr = meteoDescr;
	}
	
	
	
	
	
	
}
