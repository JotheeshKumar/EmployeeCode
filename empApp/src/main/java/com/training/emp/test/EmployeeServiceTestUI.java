package com.training.emp.test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.service.EmployeeService;
import com.training.emp.service.EmployeeServiceImpl;

public class EmployeeServiceTestUI {

	private static HashMap<String, String> accountsMap = new HashMap<String, String>();

	public static void setAccountsMap(HashMap<String, String> accountsMap) {
		EmployeeServiceTestUI.accountsMap = accountsMap;
	}

	{
		accountsMap.put("Joe", "Joe123");
		accountsMap.put("Mani", "Mani123");
		accountsMap.put("Titu", "Titu123");
		accountsMap.put("Bheem", "Bheem123");
	}

	public static HashMap<String, String> getAccountsMap() {
		return accountsMap;
	}

	public void singleMenu(boolean loginChk) {
		if (loginChk) {
			Set<Employee> employeeSet;
			int choice;
			// 1. Create an object for service
			EmployeeService service = new EmployeeServiceImpl();
			do {
				System.out.println("\nEnter the service number....." + "\n1.Find All Employees" + "\n2.Find By Id"
						+ "\n3.Find By Name" + "\n4.Update by Id" + "\n5.Adding an employee"
						+ "\n6.Deleting an employee" + "\n7.Exit");
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
					// int id = 109;
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
					System.out.println("Find By Name");
					// 2. Get input to id
					System.out.println("Enter the Name of Employee");
					String inName = sc.next();
					// int id = 109;
					try {
						// 3. call findById in service with id as input
						Employee employee = service.findByName(inName);
						// 4. Print the employee
						System.out.println(employee);
					} catch (EmployeeNotFoundException e) {
						// 5. If emp not found
					}
					break;
				case 4:
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
				case 5:
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
				case 6:
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
					System.out.println("Exit Employee Service....... ");
					break;

				}

			} while (choice < 6);

		}
	}

	public void menuSelt() {
		boolean loginChk;
		Scanner sc1 = new Scanner(System.in);
		LoginPage login = new LoginPage();
		EmployeeServiceTestUI es = new EmployeeServiceTestUI();
		System.out.println("\nEnter the service number....." + "\n1.Login" + "\n2.Reset password");
		int ts = sc1.nextInt();
		switch (ts) {
		case 1:
			loginChk = login.auth();
			es.singleMenu(loginChk);
			break;
		case 2:
			LoginPage.resetPass();
			es.menuSelt();
		}
	}

	public static void main(String[] args) {
		System.out.println("Log in...........");
		EmployeeServiceTestUI es = new EmployeeServiceTestUI();
		es.menuSelt();
	}

}
