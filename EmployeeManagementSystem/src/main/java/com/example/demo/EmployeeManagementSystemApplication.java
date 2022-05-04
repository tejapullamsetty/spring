package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementSystemApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Employee e = new Employee(1l, "TalentSprint", "Hyderabad", "100000");
		 * employeeRepository.save(e); Employee e1 = new Employee(2l, "Ravi",
		 * "Banglore", "500000"); employeeRepository.save(e1); Employee e2 = new
		 * Employee(3l, "Teja", "chennai", "600000"); employeeRepository.save(e2);
		 * Employee e3 = new Employee(4l, "Hari", "Guntur", "700000");
		 * employeeRepository.save(e3);
		 * 
		 */}

}
