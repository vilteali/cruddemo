package com.ali.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.cruddemo.dao.EmployeeRepository;
import com.ali.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	// remove @transactional from methods since JpaRepository provides this functionality
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Didn't find employee id: "+id);
		}
		
		return employee;
	}

	@Override
	public void save(Employee employee) {

		Integer employeeId = employee.getId();
		
		if(employeeId == null || employeeId != null) 
			employeeRepository.save(employee);
		
	}

	@Override
	public void deleteById(Integer id) {
		
		employeeRepository.deleteById(id);
	}

}
