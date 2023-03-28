package com.crow.clima.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crow.clima.dtos.CurrentConditionsDTO;
import com.crow.clima.dtos.TopCitiesDTO;


@Component
public class CurrentConditionsService  {

	// http://dataservice.accuweather.com/currentconditions/v1/{349308}
	// ODvd3WwA5RAILZykAGENejxqVBzy7AWq
	
	// Mapear los 5 endpoints de Current Conditions API y los parámetros que pida cada endpoint deben ser parametrizables  
	// Hacer un controller que reciba estos parámetros y devuelva información funcional y correcta acorde a estos.
	
	
	public CurrentConditionsService() {
		//currentConditions("7894");
	}
	
	public List<CurrentConditionsDTO> currentConditions(String regionCode) {

		RestTemplate rest = new RestTemplate();
		
		
			ResponseEntity<List<CurrentConditionsDTO>> rateResponse =
			        rest.exchange("http://dataservice.accuweather.com/currentconditions/v1/"+regionCode+"?apikey=ODvd3WwA5RAILZykAGENejxqVBzy7AWq&language=en-us&details=false",
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrentConditionsDTO>>() {
			            });

			List<CurrentConditionsDTO> rates = rateResponse.getBody();
			for(CurrentConditionsDTO response : rates) {
				System.out.println(response.getLocalSourceName());
				System.out.println(response.getWeatherText());
				System.out.println(response.getLocalObservationDateTime());
				System.out.println(response.getLink());
				System.out.println("--");
			}
			return rates;
			
	}

}
