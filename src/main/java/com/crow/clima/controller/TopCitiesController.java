package com.crow.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crow.clima.dtos.TopCitiesDTO;
import com.crow.clima.entity.TopCitiesEntity;
import com.crow.clima.service.TopCitiesService;

@RestController
@RequestMapping("/topCities")
public class TopCitiesController {

	@Autowired
	TopCitiesService service;

	@GetMapping("/{group}")
	public List<TopCitiesDTO> getTopCities(@PathVariable String group) {

		List<TopCitiesDTO> response = service.currentTopCities(group);

		for (TopCitiesDTO dto : response) {
			TopCitiesEntity topCitiesEntity = new TopCitiesEntity();
			topCitiesEntity.setLocalizedName(dto.getLocalizedName());
			topCitiesEntity.setTemperatureUnit(dto.getTemperature().getMetric().getUnit());
			topCitiesEntity.setTemperatureValue(dto.getTemperature().getMetric().getValue());
			topCitiesEntity.setWeatherText(dto.getWeatherText());
			service.saveTopCity(topCitiesEntity);
		}

		return response;
	}

	@PostMapping("/insertCity")
	public ResponseEntity<String> crearUsuario(@RequestBody TopCitiesDTO topCitiesDTO) {

		TopCitiesEntity topCitiesEntity = new TopCitiesEntity();
		topCitiesEntity.setLocalizedName(topCitiesDTO.getLocalizedName());
		topCitiesEntity.setWeatherText(topCitiesDTO.getWeatherText());
		topCitiesEntity.setTemperatureUnit(topCitiesDTO.getTemperature().getMetric().getUnit());
		topCitiesEntity.setTemperatureValue(topCitiesDTO.getTemperature().getMetric().getValue());
		service.saveTopCity(topCitiesEntity);
		return ResponseEntity.ok("El DTO se creó correctamente.");
	}

}
