package com.crud.application.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crud.application.entities.Employee;
import com.crud.application.services.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	
	//Injecting EmployeeService to Controller
	@Autowired
	private EmployeeService employeeService;

	
	//To visit the home page
	@GetMapping("/")
	public String home(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		
		return "index";
	}
	
	
	//To visit the addEmployee page
	@GetMapping("/addEmployee")
	public String viewAddEmployee() {
		return "addEmployee";
	}
	
	
	//To save Employee
	@PostMapping("/register")
	public String addEmployee(@ModelAttribute Employee employee, HttpSession session) {
		employeeService.addEmployee(employee);		
		System.out.println(employee);
		
		session.setAttribute("msg", "Employee added successfully.");
		return "addEmployee";
	}
	
	
	//To visit the editEmployee page
	@GetMapping("/editEmployee/{id}")
	public String viewUpdateEmployee(@PathVariable int id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		System.out.println(employee);
		model.addAttribute("employee", employee);
		
		return "editEmployee";
	}
	
	
	//To edit Employee information
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee, HttpSession session) {
		employeeService.addEmployee(employee);
		System.out.println(employee);
		
		session.setAttribute("msg", "Employee information updated successfully.");		
		return "editEmployee";
	}
	
	
	//To delete an Employee
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id, HttpSession session) {
		employeeService.deleteEmployee(id);
		
		//session.setAttribute("msg", "Employee deleted successfully.");
		return "redirect:/";
	}
	
}
