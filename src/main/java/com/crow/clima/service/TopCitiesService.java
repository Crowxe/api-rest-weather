package com.crow.clima.service;

import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crow.clima.dtos.TopCitiesDTO;
import com.crow.clima.entity.TopCitiesEntity;
import com.crow.clima.repository.TopCitiesRepository;

@Service
public class TopCitiesService {

	@Autowired
	TopCitiesRepository repository;	

	public TopCitiesService() {
	}

	public List<TopCitiesDTO> currentTopCities(String group) {
		RestTemplate rest = new RestTemplate();

		ResponseEntity<List<TopCitiesDTO>> rateResponse = rest.exchange(
				"http://dataservice.accuweather.com/currentconditions/v1/topcities/" + group
						+ "?apikey=ODvd3WwA5RAILZykAGENejxqVBzy7AWq&language=en-us&details=false",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<TopCitiesDTO>>() {
				});

		List<TopCitiesDTO> rates = rateResponse.getBody();
		return rates;

	}

	public synchronized void saveTopCity(TopCitiesDTO dto) {		
		TopCitiesEntity entity = new TopCitiesEntity();
		entity.setLocalizedName(dto.getLocalizedName());
		entity.setWeatherText(dto.getWeatherText());
		entity.setTemperatureUnit(dto.getTemperature().getMetric().getUnit());
		entity.setTemperatureValue(dto.getTemperature().getMetric().getValue());
		repository.save(entity);
	}
	
	public synchronized void saveTopCities(List<TopCitiesDTO> topCitiesDTO) {
		for (TopCitiesDTO dto : topCitiesDTO) {
			TopCitiesEntity topCitiesEntity = new TopCitiesEntity();
			topCitiesEntity.setLocalizedName(dto.getLocalizedName());
			topCitiesEntity.setTemperatureUnit(dto.getTemperature().getMetric().getUnit());
			topCitiesEntity.setTemperatureValue(dto.getTemperature().getMetric().getValue());
			topCitiesEntity.setWeatherText(dto.getWeatherText());
			repository.save(topCitiesEntity);
		}
	}

}
