package com.training.emp.service;

import java.util.Set;

import com.training.emp.dao.EmployeeDAO;
import com.training.emp.dao.EmployeeDAODummy;
import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private static EmployeeRepositoryImpl repository;
	private static EmployeeDAO dao;

	public EmployeeServiceImpl() {
		repository = new EmployeeRepositoryImpl();
		dao= new EmployeeDAODummy();
	}

	@Override
	public Set<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException {
		Employee employee = dao.findById(id);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Id Not Found");
		} else {
			return employee;
		}
	}

	@Override
	public void save(Employee employee) {
		dao.save(employee);
//		dao.save(employee);

	}

	@Override
	public void update(Employee employee) throws EmployeeNotFoundException {
		Employee result = dao.findById(employee.getId());
		if (result == null) {
			try {
				throw new EmployeeNotFoundException("Employee Id Not Found");
			} catch (EmployeeNotFoundException e) {
			System.out.println(	e.getMessage());
			}
		} else {
			dao.update(employee);
		}

	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		Employee employee = dao.findById(id);
		if (employee == null) {
			try {
				throw new EmployeeNotFoundException(("Employee doesn't exist!!"));
			} catch (EmployeeNotFoundException e) {
				System.out.println(	e.getMessage());
			}
		} else {
			dao.delete(id);
		}
	}

	@Override
	public Employee findByName(String name) throws EmployeeNotFoundException {
		Employee employee= dao.findByName(name);
		if(employee== null) {
			try {
				throw new EmployeeNotFoundException("Employee name doesn't extist!..");
			} catch (Exception e) {
				System.out.println(	e.getMessage());
			}
		}
		return employee;
	}

}
