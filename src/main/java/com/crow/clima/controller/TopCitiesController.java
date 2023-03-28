package com.crow.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crow.clima.dtos.TopCitiesDTO;
import com.crow.clima.service.TopCitiesService;

//Spring Security

@Controller
public class TopCitiesController {
	
	@Autowired
	TopCitiesService service;

    @GetMapping("/clima")
    public String getTopCities(Model model) {
        List<TopCitiesDTO> topCitiesDto = service.currentTopCities("50");
        model.addAttribute("topCitiesList", topCitiesDto);
        return "index";
    }
	
	
}
