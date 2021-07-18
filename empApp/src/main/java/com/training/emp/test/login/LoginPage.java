package com.training.emp.test.login;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.training.emp.exception.EmployeeNotFoundException;
import com.training.emp.test.EmployeeServiceTestUI;

public class LoginPage {
	private static String username;
	private String password;

	public boolean auth() {
		Scanner input = new Scanner(System.in);
		System.out.println("username: ");
		username = input.next();
		System.out.println("password: ");
		password = input.next();
		if ((password.equals(EmployeeServiceTestUI.getAccountsMap().get(username)))) {
			System.out.println("Password matches");
			return true;
		}

		else {
			System.out.println("Password Not matches");
			return false;
		}

	}
	
	public static void menuSelt() throws ClassNotFoundException, SQLException, EmployeeNotFoundException {
		boolean loginChk;
		Scanner sc1 = new Scanner(System.in);
		LoginPage login = new LoginPage();
		EmployeeServiceTestUI es = new EmployeeServiceTestUI();
		int ts = sc1.nextInt();
		switch (ts) {
		case 1:
			loginChk = login.auth();
			es.singleMenu(loginChk);
			break;
		case 2:
			LoginPage.resetPass();
		}
	}

	public static void resetPass() throws ClassNotFoundException, SQLException, EmployeeNotFoundException {
		EmployeeServiceTestUI es = new EmployeeServiceTestUI();
		System.out.println("Reset password not possible......");
		Scanner sc = new Scanner(System.in);
		System.out.println("Q1.Enter Admin password");
		String ques = sc.next();
		System.out.println("Q2.UserName:");
		String ques1 = sc.next();

		for (Entry<String, String> entry : EmployeeServiceTestUI.getAccountsMap().entrySet()) {
			if (ques.equalsIgnoreCase("Admin") && ques1.equals(entry.getKey())) {
				System.out.println("Enter new password..");
				String next = sc.next();
				EmployeeServiceTestUI.getAccountsMap().put(ques1, next);
				System.out.println("New Password added....");
				menuSelt();
				break;
			} else {
				System.out.println("Enter valid answer to reset the password");
			}
		}

	}

}
