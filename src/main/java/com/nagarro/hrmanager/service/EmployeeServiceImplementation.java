package com.nagarro.hrmanager.service;

import java.util.List;
import java.util.Optional;

import com.nagarro.hrmanager.dao.EmployeeRepository;
import com.nagarro.hrmanager.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> allEmployee() {
		return this.employeeRepository.findAll();
	}
	
	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}
	
	// @Override
	// public void updateEmployee(Employee employee,long id) {

	// 	Optional<Employee> employeeData = this.employeeRepository.findById(id);
    //     Employee data=null;
    //      if(employeeData.isPresent()){
    //          data=employee;
    //      }
	// 	this.employeeRepository.save(data);
	// }
	
	@Override
	public void deleteEmployee(Employee employee) {
		this.employeeRepository.delete(employee);
	}
	
	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = this.employeeRepository.findById(id);
		Employee emp = null;
		if(employee.isPresent()) {
			emp = employee.get();
		}	
		return emp;
	}
	
	@Override
	public Employee deleteEmployeeById(long id) {
		Optional<Employee> employeeDelete = this.employeeRepository.findById(id);
		Employee employee = null;
		if(employeeDelete.isPresent()) {
			employee = employeeDelete.get();
			employeeRepository.delete(employee);
		}
		return employee;
	}
	
	@Override
	public List<Employee> listEmployee() {
        return employeeRepository.findAll(Sort.by("employeeCode").ascending());
    }
	
	
	
}
