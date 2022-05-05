package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@RestController
@RequestMapping("/details")
public class PersonController {

	@Autowired
	private PersonDao personDao;

	@PostMapping("/saveDetails")
	public String savePerson(@RequestBody Person person) {

		personDao.savePerson(person);

		return "Successfully saved person details";

	}

	@GetMapping("/getPerons")
	public List<Person> getPerson() {

		return personDao.getPerson();
	}

}
