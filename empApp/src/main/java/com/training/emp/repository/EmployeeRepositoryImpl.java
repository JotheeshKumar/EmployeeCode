package com.training.emp.repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.training.emp.model.Employee;

public class EmployeeRepositoryImpl  {

	// dummy database
	private static Set<Employee> employeeSet;

	

	public EmployeeRepositoryImpl() {
		employeeSet = new HashSet<>();
		Employee employee1 = new Employee(101, "Immanuel");
		Employee employee2 = new Employee(102, "Saranya");
		Employee employee3 = new Employee(103, "Visha");
		Employee employee4 = new Employee(104, "Ram");
		Employee employee5 = new Employee(105, "joe");
		Employee employee6 = new Employee(106, "thilee");
		Employee employee7 = new Employee(107, "sangee");
		Employee employee8 = new Employee(108, "Mano");
		Employee employee9 = new Employee(109, "Raj");
		employeeSet.add(employee1);
		employeeSet.add(employee2);
		employeeSet.add(employee3);
		employeeSet.add(employee4);
		employeeSet.add(employee5);
		employeeSet.add(employee6);
		employeeSet.add(employee7);
		employeeSet.add(employee8);
		employeeSet.add(employee9);

		
		System.out.println("added employees in repo");
	}



	public static Set<Employee> getEmployeeSet() {
		return employeeSet;
	}



	public static void setEmployeeSet(Set<Employee> employeeSet) {
		EmployeeRepositoryImpl.employeeSet = employeeSet;
	}

	
	
	

}
