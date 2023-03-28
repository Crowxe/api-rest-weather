package com.crow.clima.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureDTO {

	private TemperatureUnitDTO Metric;
	private TemperatureUnitDTO Imperial;
	
	@JsonCreator
	public TemperatureDTO(@JsonProperty("Metric") TemperatureUnitDTO Metric,
			@JsonProperty("Imperial") TemperatureUnitDTO Imperial) {
		this.Metric = Metric;
		this.Imperial = Imperial;
	}

	public TemperatureUnitDTO getMetric() {
		return Metric;
	}

	public TemperatureUnitDTO getImperial() {
		return Imperial;
	}
}
