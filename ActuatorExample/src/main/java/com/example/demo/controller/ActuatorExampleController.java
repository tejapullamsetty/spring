package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuator")
public class ActuatorExampleController {
	
	@GetMapping("/example")
	public String actuatorExample() {
		
		return "This is Sample Actuator Example";
	}

}
