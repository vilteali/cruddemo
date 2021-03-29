package com.ali.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.cruddemo.dao.EmployeeDAO;
import com.ali.cruddemo.entity.Employee;
import com.ali.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
			
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		
		Employee employee = employeeService.findById(id);
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		
		employeeService.deleteById(id);
		
		return "Deleted employee id: "+id;
	}
	
}
