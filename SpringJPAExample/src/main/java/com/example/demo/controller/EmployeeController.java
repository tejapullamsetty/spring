package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customeexceptions.BusinessException;
import com.example.demo.customeexceptions.ControllerException;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/details")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")//http://localhost:8080/details/saveEmployee
	public ResponseEntity<?> saveEmployeeDetails(@RequestBody EmployeeEntity employeeEntity) {
		try {
			EmployeeEntity emp = employeeService.saveEmployeeDetails(employeeEntity);
			return new ResponseEntity<EmployeeEntity>(emp, HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException controllerException= new ControllerException(e.getErrorCode(),e.getErrorDesc());
			return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			ControllerException controllerException= new ControllerException("610","Something went wrong in controller layer please check"+e.getMessage());
			return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
		}
		
	}

	@PostMapping("/listOfEmp")
	public String saveListAllEmployees(@RequestBody List<EmployeeEntity> employeeList) {

		List<EmployeeEntity> empList = employeeService.saveEmployeeList(employeeList);

		return "Successfully saved list of employees into DB" + " " + empList;
	}

	@GetMapping("/getEmpList")
	public String getListOfEmp() {
		List<EmployeeEntity> empListFromDb = employeeService.getEmpList();
		return "Employee lists are" + " " + empListFromDb;
	}

	// get emp details from db by passing empId
	@GetMapping("/getEmp/{empId}")
	public ResponseEntity<?> getEmpById(@PathVariable int empId) {

		try {
			EmployeeEntity employeeEntity = employeeService.findEmpById(empId);
			return new ResponseEntity<EmployeeEntity>(employeeEntity, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException controllerException = new ControllerException(e.getErrorCode(), e.getErrorDesc());
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			ControllerException controllerException = new ControllerException("604",
					"Something went wrong in controller class please check");
			return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
		}

	}

	// update
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody EmployeeEntity employeeEntity) {

		EmployeeEntity updateEmployee = employeeService.updateEmployee(employeeEntity);

		return "Update Success" + " " + updateEmployee;
	}
	// delete

}
