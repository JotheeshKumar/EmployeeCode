package com.training.emp.service;

import java.sql.SQLException;
import java.util.Set;

import com.training.emp.dao.EmployeeDAO;
import com.training.emp.dao.EmployeeDAODummy;
import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
//	private static Employe repository;
	private EmployeeDAODummy repository;
	private static EmployeeDAO dao;

	public EmployeeServiceImpl() throws ClassNotFoundException, SQLException {
		repository = new EmployeeDAODummy();
		dao = new EmployeeDAODummy();
	}

	@Override
	public Set<Employee> findAll() {
		return dao.findAll();
	}

	@Override
	public Set<Employee> findBy(int select,String input) throws EmployeeNotFoundException {
		Set<Employee> employee = dao.findBy( select, input);
		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Id Not Found");
		} else {
			return employee;
		}
	}

	@Override
	public void save(Employee employee) {
		dao.save(employee);

	}

	@Override
	public Set<Employee> update(String input, int id, int select) throws EmployeeNotFoundException {
		Integer conv=id;
		Set<Employee> employee = dao.findBy( 1, conv.toString(id));
		if (employee == null) {
			try {
				throw new EmployeeNotFoundException(("Employee doesn't exist!!"));
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else {
			dao.update(input, id, select);
		}
		return employee;
	}

	@Override
	public void delete(int id) throws EmployeeNotFoundException {
		Integer conv=id;
		Set<Employee> employee = dao.findBy( 1, conv.toString(id));
		if (employee == null) {
			try {
				throw new EmployeeNotFoundException(("Employee doesn't exist!!"));
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
		} else {
			dao.delete(id);
		}
	}

//	@Override
//	public Employee findByName(String name) throws EmployeeNotFoundException {
//		Employee employee= dao.findByName(name);
//		if(employee== null) {
//			try {
//				throw new EmployeeNotFoundException("Employee name doesn't extist!..");
//			} catch (Exception e) {
//				System.out.println(	e.getMessage());
//			}
//		}
//		return employee;
//	}

}
