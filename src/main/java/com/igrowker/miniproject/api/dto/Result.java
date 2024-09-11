package com.igrowker.miniproject.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

	@JsonProperty("location")
	private Location location;

	@JsonProperty("currentFlow")
	private CurrentFlow currentFlow;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public CurrentFlow getCurrentFlow() {
		return currentFlow;
	}

	public void setCurrentFlow(CurrentFlow currentFlow) {
		this.currentFlow = currentFlow;
	}

}
