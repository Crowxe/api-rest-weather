package com.crow.clima.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crow.clima.dtos.CurrentConditionsDTO;

@Service
public class CurrentConditionsService {

	// ODvd3WwA5RAILZykAGENejxqVBzy7AWq

	public CurrentConditionsService() {
	}

	public List<CurrentConditionsDTO> currentConditions(String regionCode) {

		RestTemplate rest = new RestTemplate();

		ResponseEntity<List<CurrentConditionsDTO>> rateResponse = rest.exchange(
				"http://dataservice.accuweather.com/currentconditions/v1/" + regionCode
						+ "?apikey=ODvd3WwA5RAILZykAGENejxqVBzy7AWq&language=en-us&details=false",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrentConditionsDTO>>() {
				});

		List<CurrentConditionsDTO> rates = rateResponse.getBody();
		return rates;

	}

}
