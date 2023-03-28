package com.crow.clima.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentConditionsDTO implements Serializable {

	private String LocalObservationDateTime;
	private String WeatherText;
	private String LocalSourceName;
	private String Link;
	private TemperatureDTO Temperature;

	@JsonCreator
	public CurrentConditionsDTO(@JsonProperty("LocalObservationDateTime") String LocalObservationDateTime,
			@JsonProperty("WeatherText") String WeatherText, @JsonProperty("LocalSource.Name") String LocalSourceName,
			@JsonProperty("Link") String Link, @JsonProperty("Temperature") TemperatureDTO Temperature) {
		this.LocalObservationDateTime = LocalObservationDateTime;
		this.WeatherText = WeatherText;
		this.LocalSourceName = LocalSourceName;
		this.Link = Link;
		this.Temperature = Temperature;
	}

	public String getLocalObservationDateTime() {
		return this.LocalObservationDateTime;
	}

	public String getWeatherText() {
		return this.WeatherText;
	}

	public String getLocalSourceName() {
		return this.LocalSourceName;
	}

	public String getLink() {
		return this.Link;
	}

	public TemperatureDTO getTemperature() {
		return this.Temperature;
	}

}
