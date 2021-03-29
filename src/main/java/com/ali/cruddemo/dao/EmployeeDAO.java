package com.ali.cruddemo.dao;

import java.util.List;

import com.ali.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(Integer id);
	
	void save(Employee employee);
	
	void deleteById(Integer id);
	
}
