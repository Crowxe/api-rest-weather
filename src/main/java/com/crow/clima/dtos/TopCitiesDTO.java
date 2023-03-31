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

	public TopCitiesDTO() {
	}

	public String getLocalizedName() {
		return LocalizedName;
	}

	public void setLocalizedName(String localizedName) {
		LocalizedName = localizedName;
	}

	public void setWeatherText(String weatherText) {
		WeatherText = weatherText;
	}

	public void setTemperature(TemperatureDTO temperature) {
		Temperature = temperature;
	}

	public String getWeatherText() {
		return WeatherText;
	}

	public TemperatureDTO getTemperature() {
		return Temperature;
	}
}
