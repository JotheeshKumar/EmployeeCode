package com.training.emp.dao;

import java.util.Set;

import com.training.emp.model.Employee;

public interface EmployeeDAO {

	Set<Employee> findAll();

	void save(Employee employee);

	void delete(int id);

	void update(String input, int id, int select);

	Set<Employee> findBy(int select, String input);

}
