package com.ali.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ali.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
