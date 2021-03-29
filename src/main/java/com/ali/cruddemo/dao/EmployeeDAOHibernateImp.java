package com.ali.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ali.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		
		// always call in the query an object
		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(Integer id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
		
	}

	@Override
	public void deleteById(Integer id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("delete from Employee where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
