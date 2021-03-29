package com.ali.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		List<Employee> employees = entityManager.createQuery("from Employee", Employee.class).getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(Integer id) {
		
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		entityManager.merge(employee);		
	}

	@Override
	public void deleteById(Integer id) {
		
		Query<Employee> query = (Query<Employee>) entityManager.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
	}

}
