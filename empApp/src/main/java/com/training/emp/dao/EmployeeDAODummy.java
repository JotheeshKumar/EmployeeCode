package com.training.emp.dao;

import java.util.Iterator;
import java.util.Set;

import com.training.emp.model.Employee;
import com.training.emp.repository.EmployeeRepositoryImpl;

public class EmployeeDAODummy implements EmployeeDAO {

	public EmployeeDAODummy() {
		try {

			System.out.println("Created a connection to the dummy Repository");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Employee> findAll() {
	//	return EmployeeRepositoryImpl.employeeSet;
		return EmployeeRepositoryImpl.getEmployeeSet();
	}

	@Override
	public Employee findById(int id) {
	//	for (Employee employee : EmployeeRepositoryImpl.employeeSet) {
			for (Employee employee : EmployeeRepositoryImpl.getEmployeeSet()) {
			if (employee.getId() == id) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public void save(Employee employee) {
		//EmployeeRepositoryImpl.employeeSet.add(employee);
		EmployeeRepositoryImpl.getEmployeeSet().add(employee);
	}

	@Override
	public void update(Employee employee) {
		// emp - exisiting emp
		// employee - new data to be updated
		//for (Employee emp : EmployeeRepositoryImpl.employeeSet) {
			for (Employee emp : EmployeeRepositoryImpl.getEmployeeSet()) {
			if (emp.getId() == employee.getId()) {
				emp.setName(employee.getName());
			}
		}

	}

	@Override
	public void delete(int id) {
		//Iterator<Employee> it = EmployeeRepositoryImpl.employeeSet.iterator();
		Iterator<Employee> it = EmployeeRepositoryImpl.getEmployeeSet().iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
			}
		}

	}

	@Override
	public Employee findByName(String name) {
		for (Employee emp : EmployeeRepositoryImpl.getEmployeeSet()) {
			String checkName = emp.getName();
			if(checkName.equalsIgnoreCase(name)) {
				return emp;
			}
		}
		return null;
	}
}
