package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getPersonDetails(){
		
		List<String> personDetails=new ArrayList<String>();
		
		personDetails.addAll(jdbcTemplate.queryForList("select name from person;",String.class));
		
		return personDetails;
	}

}
