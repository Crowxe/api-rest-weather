package com.crow.clima.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopCitiesDTO {

	private String LocalizedName;
	private String WeatherText;
	private TemperatureDTO Temperature;

	@JsonCreator
	public TopCitiesDTO(@JsonProperty("LocalizedName") String LocalizedName,
			@JsonProperty("WeatherText") String WeatherText, @JsonProperty("Temperature") TemperatureDTO Temperature) {
		this.LocalizedName = LocalizedName;
		this.WeatherText = WeatherText;
		this.Temperature = Temperature;
	}

	public String getLocalizedName() {
		return LocalizedName;
	}

	public String getWeatherText() {
		return WeatherText;
	}

	public TemperatureDTO getTemperature() {
		return Temperature;
	}
}
