package com.crow.clima.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TopCitiesDTO {
	
	private String LocalizedName;
	private String WeatherText;
	
	 @JsonCreator
	    public TopCitiesDTO(@JsonProperty("LocalizedName") String LocalizedName,
	                        @JsonProperty("WeatherText") String WeatherText) {
	        this.LocalizedName = LocalizedName;
	        this.WeatherText = WeatherText;
	    }
	
	
	public String getLocalizedName() {
		return LocalizedName;
	}
	
	public String getWeatherText() {
		return WeatherText;
	}
}
