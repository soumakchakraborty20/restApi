package com.nagarro.hrmanager.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.hrmanager.entity.Employee;
import com.nagarro.hrmanager.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;



	@GetMapping("/employeeList")
	public ResponseEntity<List<Employee>> Employee() {
		List<Employee> employee = this.employeeService.allEmployee();
		return ResponseEntity.of(Optional.of(employee));
	}

	@GetMapping("/showFormNewEmployee")
	public String employeeForm() {
		return "AddNewEmployee";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateEmployeeForm(@PathVariable("id") long id,Model model) {
		Employee employee = this.employeeService.getEmployeeById(id);
		model.addAttribute("employeeData", employee);
		return "UpdateEmployeeDetails";
	}


	@PostMapping("/saveEmployee")
	public void saveEmployee(@RequestBody Employee employeeData) {
		System.out.println("saveing");
		this.employeeService.saveEmployee(employeeData);
	}

	// @PutMapping("/updateEmployee/{id}")
	// public Employee updateEmployee(@RequestBody Employee employeeData,@PathVariable("id") long id) {
		
	// 	this.employeeService.updateEmployee(employeeData,id);
	// 	System.out.println("updating");
	// 	return employeeData;
	// }

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") long id,Model model) {
		System.out.println("deleting");
		this.employeeService.deleteEmployeeById(id);
	}



}
