package com.training.emp.test;

import java.awt.Choice;
import java.util.Scanner;
import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.repository.EmployeeRepositoryImpl;
import com.training.emp.service.EmployeeService;
import com.training.emp.service.EmployeeServiceImpl;

public class EmployeeServiceTestUI {
	public static void main(String[] args) {
		Set<Employee> employeeSet;
		int choice;
		// 1. Create an object for service
		EmployeeService service = new EmployeeServiceImpl();
		do {
		System.out.println("\nEnter the service number....."
				+ "\n1.Find All Employees"
				+ "\n2.Find By Id"
				+ "\n3.Update by Id"
				+ "\n4.Adding an employee"
				+ "\n5.Deleting an employee");
		Scanner sc = new Scanner(System.in);
		 choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Employees");
			employeeSet = service.findAll();
			for (Employee employee : employeeSet) {
				System.out.println(employee);
			}
			break;
		case 2:
			System.out.println("Find By Id");
			// 2. Get input to id
			System.out.println("Enter the ID of Employee");
			int id = sc.nextInt();
			//int id = 109;
			try {
				// 3. call findById in service with id as input
				Employee employee = service.findById(id);
				// 4. Print the employee
				System.out.println(employee);
			} catch (EmployeeNotFoundException e) {
				// 5. If emp not found
			}
			break;
		case 3:
			System.out.println("Update Id");
			// 1. Create New employee Data to be updated
			System.out.println("Enter the ID of the Employee");
			int idOld = sc.nextInt();
			System.out.println("Enter the Name of the Employee");
			String nameOld = sc.next();
			Employee updateEmployee = new Employee(idOld, nameOld);
			try {
				// 2. call the update method in service with input emp obje
				service.update(updateEmployee);
				employeeSet = service.findAll();
				System.out.println(employeeSet);
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			System.out.println("Adding an employee");
			System.out.println("Enter the ID of the Employee");
			int idNew = sc.nextInt();
			System.out.println("Enter the Name of the Employee");
			String nameNew = sc.next();
			Employee newEmployee = new Employee(idNew, nameNew);
			service.save(newEmployee);
			employeeSet = service.findAll();
			System.out.println(employeeSet);

			break;
		case 5:
			System.out.println("Deleting an employee by ID");
			System.out.println("Enter the ID of the Employee");
			int idDelete = sc.nextInt();
			
			try {
				service.delete(idDelete);
				employeeSet = service.findAll();
				System.out.println(employeeSet);
			} catch (EmployeeNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		

		default:
			System.out.println("Employee Service");
			break;

		}
		
		}while(choice<6);

	}

}
