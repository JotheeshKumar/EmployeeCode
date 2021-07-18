package com.training.emp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class SelectTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		String sql = "select * from employee";
		String url = "jdbc:mysql://localhost:3306/db_name";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected!");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//ArrayList<E>
			while (rs.next()) {
				
				
				
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5));
			}
		} catch (SQLException ex) {
			throw new Error("Error ", ex);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

} // class
