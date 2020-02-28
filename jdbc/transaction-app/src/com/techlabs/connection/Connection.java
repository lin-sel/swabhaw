package com.techlabs.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static String url = "jdbc:mysql://127.0.0.1/test?characterEncoding=latin1&user=swabhav&password=swabhav";
	private static java.sql.Connection conn = null;

	private Connection() {
	}

	public static java.sql.Connection getInstance() throws ClassNotFoundException, SQLException {
		if (conn != null) {
			return createInstance();
		}
		return conn;
	}

	private static java.sql.Connection createInstance() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(url);
		return conn;
	}
}
