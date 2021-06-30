package com.northwind.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
   @JsonProperty("speed")
   private Double  speed;
   @JsonProperty("deg")
   private Integer deg;
   @JsonProperty("gust")
   private Double  gust;
   
   
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Integer getDeg() {
		return deg;
	}
	public void setDeg(Integer deg) {
		this.deg = deg;
	}
	public Double getGust() {
		return gust;
	}
	public void setGust(Double gust) {
		this.gust = gust;
	}
	
	
	@Override
	public String toString() {
		return "WindDTO [speed=" + speed + ", deg=" + deg + ", gust=" + gust + "]";
	}
}
