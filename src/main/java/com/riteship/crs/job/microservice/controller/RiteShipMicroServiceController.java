package com.riteship.crs.job.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riteship.crs.job.microservice.config.CloudConfig;

@RestController
public class RiteShipMicroServiceController {

	@Autowired
	CloudConfig configuration;

	@GetMapping("/endpoint")
	public String retrieveLimits() {
		return configuration.getValue();
	}

}
