package com.northwind.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RainDTO {
	@JsonProperty("3h")
	private Double volumRain;

	public Double getVolumRain() {
		return volumRain;
	}

	public void setVolumRain(Double volumRain) {
		this.volumRain = volumRain;
	}

	@Override
	public String toString() {
		return "RainDTO [volumRain=" + volumRain + "]";
	}
}
