package com.igrowker.miniproject.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentFlow {

	@JsonProperty("jamFactor")
	private Double jamFactor;

	public Double getJamFactor() {
		return jamFactor;
	}

	public void setJamFactor(Double jamFactor) {
		this.jamFactor = jamFactor;
	}

}
