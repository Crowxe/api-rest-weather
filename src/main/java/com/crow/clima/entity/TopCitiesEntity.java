package com.crow.clima.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "top_cities_entity")
public class TopCitiesEntity {
	
	@Id
	@Column(name = "localized_name")
    private String localizedName;

    @Column(name = "weather_text")
    private String weatherText;

    @Column(name = "temperature_value")
    private Double temperatureValue;

    @Column(name = "temperature_unit")
    private String temperatureUnit;
    
    public TopCitiesEntity() {}

    public TopCitiesEntity(String localizedName, String weatherText, Double temperatureMetricValue, String temperatureUnit) {
        this.localizedName = localizedName;
        this.weatherText = weatherText;
        this.temperatureValue = temperatureMetricValue;
        this.temperatureUnit = temperatureUnit;
    }

	public String getLocalizedName() {
		return localizedName;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}

	public String getWeatherText() {
		return weatherText;
	}

	public void setWeatherText(String weatherText) {
		this.weatherText = weatherText;
	}

	public Double getTemperatureValue() {
		return temperatureValue;
	}

	public void setTemperatureValue(Double temperatureValue) {
		this.temperatureValue = temperatureValue;
	}

	public String getTemperatureUnit() {
		return temperatureUnit;
	}

	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}
}
