package com.crow.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crow.clima.dtos.TopCitiesDTO;
import com.crow.clima.service.TopCitiesService;

//Spring Security

@RestController
@RequestMapping("/topcities")
public class TopCitiesController {
	
	@Autowired
	TopCitiesService service;

    @GetMapping("/{group}")
    public List<TopCitiesDTO> getTopCities(@PathVariable String group) {
        List<TopCitiesDTO> response = service.currentTopCities(group);
        return response;
    }
	
	
}
