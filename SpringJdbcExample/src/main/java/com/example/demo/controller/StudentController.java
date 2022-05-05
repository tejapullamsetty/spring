package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/details")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;

	@GetMapping
	public String getDetails() {
		return "Student Details";
	}

	@GetMapping("/getPersonDetails")
	public List<String> getPersonDetails() {

		return studentRepository.getPersonDetails();
	}

}
