package com.example.demo.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.controller.pojo.EmployeeDetails;

@RestController
public class RestTemplateExample {

	@Autowired
	RestTemplate restTemplate;

	// 1--->autowire resttemplate 2--use HttpHeaders to set Request headers 3--use
	// HttpEntity to wrap the request object
	@RequestMapping("/save/details")
	public String createEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<EmployeeDetails> entity = new HttpEntity<EmployeeDetails>(employeeDetails, httpHeaders);

		ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8080/details/saveEmployee",
				HttpMethod.POST, entity, String.class);
		return responseEntity.getBody();

	}	

}
