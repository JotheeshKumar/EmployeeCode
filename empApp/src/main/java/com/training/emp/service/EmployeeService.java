package com.training.emp.service;

import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;

public interface EmployeeService {
	Set<Employee> findAll();

	Set<Employee> findBy(int select,String input) throws EmployeeNotFoundException;
	
	//Employee findByName(String name) throws EmployeeNotFoundException;

	void save(Employee employee);

	void delete(int id) throws EmployeeNotFoundException;

	Set<Employee> update(String input, int id, int select) throws EmployeeNotFoundException;

}
