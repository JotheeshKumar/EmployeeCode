package com.training.emp.test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

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

	public static void resetPass() {
		EmployeeServiceTestUI es = new EmployeeServiceTestUI();
		System.out.println("Reset password not possible......");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Q1.Enter Admin password");
//		String ques = sc.next();
//		System.out.println("Q2.UserName:");
//		String ques1 = sc.next();
//
//		for (Entry<String, String> entry : EmployeeServiceTestUI.getAccountsMap().entrySet()) {
//			if (ques.equalsIgnoreCase("Admin") && ques1.equals(entry.getKey())) {
//				System.out.println("Enter new password..");
//				String next = sc.next();
//				EmployeeServiceTestUI.getAccountsMap().put(ques1, next);
//				System.out.println("New Password added....");
//				es.menuSelt();
//				break;
//			} else {
//				System.out.println("Enter valid answer to reset the password");
//			}
//		}

	}

}
