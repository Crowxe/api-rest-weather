package com.crow.clima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crow.clima.dtos.CurrentConditionsDTO;
import com.crow.clima.service.CurrentConditionsService;

@RestController
@RequestMapping("/regionCode")
public class CurrentConditionController {

	//cd Downloads/clima - add commit y push
	
	
	@Autowired
	private CurrentConditionsService service;
	//Preguntar @PathVariable
	 @GetMapping("/{regionCode}")
	    public List<CurrentConditionsDTO> getCurrentConditions(@PathVariable String regionCode) {
	        List<CurrentConditionsDTO> response = service.currentConditions(regionCode);
	        return response;
	    }
}
