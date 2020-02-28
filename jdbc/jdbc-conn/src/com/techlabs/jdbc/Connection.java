package com.techlabs.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	public static void main(String[] args){
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?characterEncoding=latin1&user=swabhav&password=swabhav");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(conn.getClass());
		try {
			System.out.println(conn.getCatalog());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
