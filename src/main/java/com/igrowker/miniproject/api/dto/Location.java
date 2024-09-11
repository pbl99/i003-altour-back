package com.igrowker.miniproject.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Location {

	@JsonProperty("description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
