package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

	private static Connection conn =null;

	public static Connection getConnection() {
		String url;
		String userName;
		String password;

		if (conn == null) {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Try of connection class");
				url = "jdbc:mysql://localhost:3306/student_tracker";
				userName = "root";
				password = "MEMON@123";
				conn = DriverManager.getConnection(url, userName, password);
				System.out.println(conn);
				
			} catch (Exception e) {
				// TODO: handle exception
				
			}
		}
		return conn;

	}
}
