package com.crud.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.application.entities.Employee;
import com.crud.application.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	//To save an Employee
	public void addEmployee(Employee employee) {
		employeeRepo.save(employee);
	}
	
	
	//To get all Employees
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	
	//To get an Employee by his id
	public Employee getEmployeeById(int id) {
		//return employeeRepo.findById(id).orElse(null);
		
		//Or,		
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			return null;
		}
	}
	
	//To delete an Employee
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
	}
	
}
