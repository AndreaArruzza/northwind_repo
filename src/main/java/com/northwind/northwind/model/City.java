package com.northwind.northwind.model;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
	@JsonProperty("id")
    private String id;
	@JsonProperty("name")
    private String name;
	@JsonProperty("coord")
    private List<Coord> coord;
	@JsonProperty("sunrise")
    private Timestamp sunrise;
	@JsonProperty("sunset")
    private Timestamp sunset;
	@JsonProperty("country")	
	private String country;
	@JsonProperty("population")	
	private String population;
	@JsonProperty("timezone")	
	private String timezone;
	
	
	
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Coord> getCoord() {
		return coord;
	}
	public void setCoord(List<Coord> coord) {
		this.coord = coord;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Timestamp getSunrise() {
		return sunrise;
	}
	public void setSunrise(Timestamp sunrise) {
		this.sunrise = sunrise;
	}
	public Timestamp getSunset() {
		return sunset;
	}
	public void setSunset(Timestamp sunset) {
		this.sunset = sunset;
	}
	
	
	@Override
	public String toString() {
		return "CityDTO [id=" + id + ", name=" + name + ", coord=" + coord + ", sunrise=" + sunrise + ", sunset="
				+ sunset + ", country=" + country + ", population=" + population + ", timezone=" + timezone + "]";
	}
}
