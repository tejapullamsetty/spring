package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customeexceptions.BusinessException;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeEntity saveEmployeeDetails(EmployeeEntity employeeEntity) {
		if (employeeEntity.getEmpName().isEmpty() || employeeEntity.getEmpName().length() == 0) {
			throw new BusinessException("605", "Please enter employee name");
		}
		try {
			EmployeeEntity employeeDetails = employeeRepository.save(employeeEntity);
			return employeeDetails;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "Employee entity object is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("607", "Something went wrong in service layer please check" + e.getMessage());
		}

	}

	public List<EmployeeEntity> saveEmployeeList(List<EmployeeEntity> listOfEmp) {

		return employeeRepository.saveAll(listOfEmp);
	}

	public List<EmployeeEntity> getEmpList() {

		return employeeRepository.findAll();
	}

	public EmployeeEntity findEmpById(int employeeId) {

		try {
			return employeeRepository.findById(employeeId).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("601", "EmployeeId is empty please pass employeeId" + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new BusinessException("602", "Given EmployeeId is not present in the Database" + e.getMessage());
		}
	}

	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {

		EmployeeEntity empDetailsFromDb = employeeRepository.findById(employeeEntity.getEmpId()).orElse(null);
		empDetailsFromDb.setEmpName(employeeEntity.getEmpName());
		empDetailsFromDb.setEmpAddre(employeeEntity.getEmpAddre());
		empDetailsFromDb.setEmpSalary(employeeEntity.getEmpSalary());
		return employeeRepository.save(empDetailsFromDb);
	}
}
