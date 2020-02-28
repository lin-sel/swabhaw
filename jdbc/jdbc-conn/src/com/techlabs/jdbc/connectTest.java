package com.techlabs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectTest {

	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?user=swabhav&password=swabhav");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(conn.getClass());
	}

}
