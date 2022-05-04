package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String employeeName;
	private String employeeAddress;
	private String emplyeeSalary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmplyeeSalary() {
		return emplyeeSalary;
	}

	public void setEmplyeeSalary(String emplyeeSalary) {
		this.emplyeeSalary = emplyeeSalary;
	}

	public Employee(Long id, String employeeName, String employeeAddress, String emplyeeSalary) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.emplyeeSalary = emplyeeSalary;
	}

	public Employee() {

	}

}
