package com.crow.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crow.clima.dtos.TopCitiesDTO;
import com.crow.clima.service.TopCitiesService;

@RestController
@RequestMapping("/topCities")
public class TopCitiesController {

	@Autowired
	TopCitiesService service;

	@GetMapping("/{group}")
	public List<TopCitiesDTO> getTopCities(@PathVariable String group) {

		List<TopCitiesDTO> response = service.currentTopCities(group);

		service.saveTopCities(response);

		return response;
	}

	@PostMapping("/insertCity")
	public ResponseEntity<String> crearUsuario(@RequestBody TopCitiesDTO topCitiesDTO) {
		service.saveTopCity(topCitiesDTO);
		return ResponseEntity.ok(topCitiesDTO.getLocalizedName() + " se creó correctamente.");
	}

}
