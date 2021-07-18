package com.training.emp.test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.model.Employee;
import com.training.emp.service.EmployeeService;
import com.training.emp.service.EmployeeServiceImpl;
import com.training.emp.test.login.LoginPage;

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

	public void singleMenu(boolean loginChk) throws ClassNotFoundException, SQLException, EmployeeNotFoundException {
		if (loginChk) {
			Set<Employee> employeeSet;
			int choice;
			// 1. Create an object for service
			EmployeeService service = new EmployeeServiceImpl();
			do {
				System.out.println("\nEnter the service number....." + "\n1.Find All Employees" 
						+ "\n2.Find By..." + "\n3.Update by Id" + "\n4.Adding an employee"
						+ "\n5.Deleting an employee" + "\n6.Exit");
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
					System.out.println(" 1.ID"+" 2.first name"+" 3.last name"+" 4.address"+" 5.city");
					int ip = sc.nextInt();
					switch(ip) {
					case 1:
						System.out.println("Enter the ID of Employee");
						String input = sc.next();
						employeeSet = service.findBy(1, input);
						for (Employee employee : employeeSet) {
							System.out.println(employee);
						}
						break;
					case 2:
						System.out.println("Enter the first name of Employee");
						String input1 = sc.next();
						employeeSet = service.findBy(2, input1);
						for (Employee employee : employeeSet) {
							System.out.println(employee);
						}
						break;
					case 3:
						System.out.println("Enter the last name of Employee");
						String input2 = sc.next();
						employeeSet = service.findBy(3, input2);
						for (Employee employee : employeeSet) {
							System.out.println(employee);
						}
						break;
					case 4:
						System.out.println("Enter the address of Employee");
						String input3 = sc.next();
						employeeSet = service.findBy(4, input3);
						for (Employee employee : employeeSet) {
							System.out.println(employee);
						}
						break;
					case 5:
						System.out.println("Enter the city of Employee");
						String input4 = sc.next();
						employeeSet = service.findBy(5, input4);
						for (Employee employee : employeeSet) {
							System.out.println(employee);
						}
						break;
					}
					
					break;
				
					
				case 3:
					System.out.println("Enter the employee ID that need to be updated : ");
					int id = sc.nextInt();
					System.out.println("Enter the employee ID that need to be updated : ");
					int select = sc.nextInt();
					System.out.println("Enter the employee ID that need to be updated : ");
					String input = sc.next();
					employeeSet = service.update(input, id, select);
					employeeSet = service.findBy(1, String.valueOf(id));
					for (Employee employee : employeeSet) {
						System.out.println(employee);
					}
					
					break;
				case 4:
					System.out.println("Adding an employee");
					System.out.println("Enter the ID of the Employee");
					int idNew = sc.nextInt();
					System.out.println("Enter the First Name of the Employee");
					String fname = sc.next();
					System.out.println("Enter the Last Name of the Employee");
					String lname = sc.next();
					System.out.println("Enter the address of the Employee");
					String address = sc.next();
					System.out.println("Enter the city of the Employee");
					String city = sc.next();
					Employee newEmployee = new Employee(idNew, fname, lname,address,city);
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

	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, EmployeeNotFoundException {
		System.out.println("Log in...........");
		EmployeeServiceTestUI es = new EmployeeServiceTestUI();
		System.out.println("\nEnter the service number....." 
		+ "\n1.Login" 
		+ "\n2.Reset password");
		LoginPage.menuSelt();
	}

}
