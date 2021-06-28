package com.northwind.northwind.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayDTO {
	@JsonProperty("pod")
	private String partOfDay;

	public String getPartOfDay() {
		return partOfDay;
	}

	public void setPartOfDay(String partOfDay) {
		this.partOfDay = partOfDay;
	}

	@Override
	public String toString() {
		return "DayDTO [partOfDay=" + partOfDay + "]";
	}
}
