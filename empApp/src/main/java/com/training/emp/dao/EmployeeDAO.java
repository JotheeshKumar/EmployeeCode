package com.training.emp.dao;

import java.util.Set;

import com.training.emp.model.Employee;

public interface EmployeeDAO {

	Set<Employee> findAll();

	Employee findById(int id);
	
	Employee findByName(String name);
	
	void save(Employee employee);

	void update(Employee employee);

	void delete(int id);
	
	

}
