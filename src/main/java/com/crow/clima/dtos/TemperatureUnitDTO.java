package com.crow.clima.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemperatureUnitDTO {

	private double Value;
	private String Unit;
	private int UnitType;
	
	@JsonCreator
	public TemperatureUnitDTO(@JsonProperty("Value") double Value,
			@JsonProperty("Unit") String Unit, @JsonProperty("UnitType") int UnitType) {
		this.Value = Value;
		this.Unit = Unit;
		this.UnitType = UnitType;
	}

	public double getValue() {
		return Value;
	}

	public String getUnit() {
		return Unit;
	}

	public int getUnitType() {
		return UnitType;
	}
}
