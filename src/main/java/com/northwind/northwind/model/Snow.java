package com.northwind.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {
	@JsonProperty("3h")
	private Double volumSnow;

	public Double getVolumSnow() {
		return volumSnow;
	}

	public void setVolumSnow(Double volumSnow) {
		this.volumSnow = volumSnow;
	}

	@Override
	public String toString() {
		return "SnowDTO [volumSnow=" + volumSnow + "]";
	}
}
