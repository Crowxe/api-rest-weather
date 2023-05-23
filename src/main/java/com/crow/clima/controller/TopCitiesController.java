package com.crow.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crow.clima.dtos.TopCitiesDTO;
import com.crow.clima.entity.TopCitiesEntity;
import com.crow.clima.service.TopCitiesService;

@RestController
@RequestMapping("/topCities")
@CrossOrigin(origins = "http://localhost:3000")
public class TopCitiesController {

	@Autowired
	TopCitiesService service;

	@GetMapping("/{group}")
	public List<TopCitiesDTO> getTopCities(@PathVariable String group) {

		List<TopCitiesDTO> response = service.currentTopCities(group);

		service.saveTopCities(response);

		return response;
	}

	@GetMapping("/seeAll")
	public List<TopCitiesEntity> getAll() {

		return service.getAll();

	}
	
	@GetMapping("/seeAllUpdated/{group}")
	public List<TopCitiesEntity> getAllUpdated(@PathVariable String group) {
		
		return service.getAllUpdated(group);
		
	}
	@GetMapping("/search")
	public List<TopCitiesEntity> searchCities(@RequestParam("query") String query) {
		return service.searchCities(query);
	}

	@PostMapping("/insertCity")
	public ResponseEntity<String> createCity(@RequestBody TopCitiesDTO topCitiesDTO) {
		service.saveTopCity(topCitiesDTO);
		return ResponseEntity.ok(topCitiesDTO.getLocalizedName() + " se creó correctamente.");
	}

}
