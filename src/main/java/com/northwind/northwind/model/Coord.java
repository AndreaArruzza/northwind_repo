package com.northwind.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord {
	@JsonProperty("lat")
	private Double lat;
	@JsonProperty("lon")
	private Double lon;
	
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	@Override
	public String toString() {
		return "CoordDTO [lat=" + lat + ", lon=" + lon + "]";
	}
}
