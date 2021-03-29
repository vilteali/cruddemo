package com.ali.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ali.cruddemo.dao.EmployeeDAO;
import com.ali.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImp(@Qualifier("employeeDAOJpaImp") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(Integer id) {
		
		Employee employee = employeeDAO.findById(id);
		
		if(employee == null) 
			throw new RuntimeException("Employee id: "+id+" not found");
		
		return employee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {

		Integer employeeId = employee.getId();
		
		if(employeeId == null || employeeId != null) 
			employeeDAO.save(employee);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		
		Employee employee = employeeDAO.findById(id);
		
		if(employee == null) {
			throw new RuntimeException("Employee id: "+id+" not found");
		}
		
		employeeDAO.deleteById(id);
	}

}
