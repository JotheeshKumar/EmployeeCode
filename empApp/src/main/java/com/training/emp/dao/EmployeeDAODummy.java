package com.training.emp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.training.emp.model.Employee;

public class EmployeeDAODummy implements EmployeeDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rt;
	private Statement stmt;
	public static String URL = "jdbc:mysql://localhost:3306/db_name";
	public static String uName = "root";
	public static String uPasswrd = "root";

	private static Set<Employee> employeeSet;

	public EmployeeDAODummy() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, uName, uPasswrd);
			System.out.println("Connected!");
			stmt = con.createStatement();
			System.out.println("Created a connection to the dummy Repository");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Employee> findAll() {
		String sql = "select * from employee";
		try {
			pstmt = con.prepareStatement(sql);
			rt = pstmt.executeQuery();
			employeeSet = new HashSet<Employee>();
			while (rt.next()) {
				Employee employee = new Employee(rt.getInt("emp_id"), rt.getString("emp_fname"),
						rt.getString("emp_lname"), rt.getString("emp_Address"), rt.getString("emp_city"));
				employeeSet.add(employee);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeSet;
	}

	@Override
	public Set<Employee> findBy(int select,String input) {
		
		String sql1 = "select * from employee where emp_id=" + "?";
		String sql2 = "select * from employee where emp_fname=" + "?";
		String sql3 = "select * from employee where emp_lname=" + "?";
		String sql4 = "select * from employee where emp_address=" + "?";
		String sql5 = "select * from employee where emp_city=" + "?";
		int i = select;
		switch (i) {
		case 1:

			try {
				int id = Integer.parseInt(input);
				pstmt = con.prepareStatement(sql1);
				pstmt.setInt(1, id);
				rt = pstmt.executeQuery();
				employeeSet = new HashSet<Employee>();
				while (rt.next()) {
					Employee employee = new Employee(rt.getInt("emp_id"), rt.getString("emp_fname"),
							rt.getString("emp_lname"), rt.getString("emp_Address"), rt.getString("emp_city"));
					employeeSet.add(employee);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				String fname = input;
				
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, input);
				rt = pstmt.executeQuery();
				employeeSet = new HashSet<Employee>();
				while (rt.next()) {
					
					Employee employee = new Employee(rt.getInt("emp_id"), rt.getString("emp_fname"),
							rt.getString("emp_lname"), rt.getString("emp_Address"), rt.getString("emp_city"));
					employeeSet.add(employee);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				String lname = input;
				
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, input);
				rt = pstmt.executeQuery();
				employeeSet = new HashSet<Employee>();
				while (rt.next()) {
					Employee employee = new Employee(rt.getInt("emp_id"), rt.getString("emp_fname"),
							rt.getString("emp_lname"), rt.getString("emp_Address"), rt.getString("emp_city"));
					employeeSet.add(employee);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				String addrs = input;
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, input);
				rt = pstmt.executeQuery();
				employeeSet = new HashSet<Employee>();
				while (rt.next()) {
					Employee employee = new Employee(rt.getInt("emp_id"), rt.getString("emp_fname"),
							rt.getString("emp_lname"), rt.getString("emp_Address"), rt.getString("emp_city"));
					employeeSet.add(employee);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 5:
			try {
				String city = input;
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, input);
				rt = pstmt.executeQuery();
				employeeSet = new HashSet<Employee>();
				while (rt.next()) {
					Employee employee = new Employee(rt.getInt("emp_id"), rt.getString("emp_fname"),
							rt.getString("emp_lname"), rt.getString("emp_Address"), rt.getString("emp_city"));
					employeeSet.add(employee);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		return employeeSet;

	}

		
		

	@Override
	public void save(Employee employee) {
		String sql = "insert into 'employee'(`emp_id`, `emp_fname`, `emp_lname`, `emp_address`, `emp_city`) values (?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getFirstName());
			pstmt.setString(4, employee.getAddress());
			pstmt.setString(5, employee.getCityName());
			rt = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(String input, int id, int select) {
		int emp_id = id;

		String sql1 = "update employee set emp_fname=? where emp_id=" + emp_id;
		String sql2 = "update employee set emp_lname=? where emp_id=" + emp_id;
		String sql3 = "update employee set emp_address=? where emp_id=" + emp_id;
		String sql4 = "update employee set emp_city=? where emp_id=" + emp_id;
		System.out.println("1.First name update"+"\n2.Last name update3.Address of employee4.City update");
		int i = select;
		switch (i) {
		case 1:

			try {
				String fname = input;
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1, fname);
				rt = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				String lname = input;
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, lname);
				rt = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				String addrs = input;
				pstmt = con.prepareStatement(sql3);
				pstmt.setString(1, addrs);
				rt = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			try {
				String city = input;
				pstmt = con.prepareStatement(sql4);
				pstmt.setString(1, city);
				rt = pstmt.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		String sql = "update employee set emp_fname='Joe', emp_lname='Bidon' where emp_id=13;";

	}

	@Override
	public void delete(int id) {

		String sql = "DELETE FROM employee WHERE emp_id =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
