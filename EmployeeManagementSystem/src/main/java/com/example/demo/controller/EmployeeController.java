package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listOfEmployees(Model model) {

		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";

	}

	@GetMapping("/employee/new")
	public String createEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployees(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employee/edit/{id})")
	public String editEmployee(@PathVariable Long id, Model model) {
		System.out.println("employeeService.getEmployeeById(id)" + employeeService.getEmployeeById(id));
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";

	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {

		Employee employeePresentInDB = employeeService.getEmployeeById(id);

		employeePresentInDB.setId(id);
		employeePresentInDB.setEmployeeAddress(employee.getEmployeeAddress());
		employeePresentInDB.setEmployeeName(employee.getEmployeeName());
		employeePresentInDB.setEmplyeeSalary(employee.getEmplyeeSalary());

		employeeService.updateEmployee(employeePresentInDB);
		return "redirect:/employees";

	}

	@GetMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
