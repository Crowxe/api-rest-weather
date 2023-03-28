package com.crow.clima.service;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crow.clima.dtos.TopCitiesDTO;

@Service
public class TopCitiesService {

	public TopCitiesService() {
	}
	
	public List<TopCitiesDTO> currentTopCities(String group) {
		RestTemplate rest = new RestTemplate();
		
		//Mapeo el JSON a una Lista de Objetos TopCitiesDTO
		ResponseEntity<List<TopCitiesDTO>> rateResponse =
				rest.exchange("http://dataservice.accuweather.com/currentconditions/v1/topcities/"+group+"?apikey=ODvd3WwA5RAILZykAGENejxqVBzy7AWq&language=en-us&details=false",
						HttpMethod.GET, null, new ParameterizedTypeReference<List<TopCitiesDTO>>() {
	            });
		
		System.out.println(rateResponse.getBody());
		List<TopCitiesDTO> rates = rateResponse.getBody();
		return rates;
		
	}
		
}
