package com.igrowker.miniproject.api.dto;

public class JamDataDTO {

	private String description;
	private double jamFactor;

	public JamDataDTO(String description, double jamFactor) {
		this.description = description;
		this.jamFactor = jamFactor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getJamFactor() {
		return jamFactor;
	}

	public void setJamFactor(double jamFactor) {
		this.jamFactor = jamFactor;
	}

}
