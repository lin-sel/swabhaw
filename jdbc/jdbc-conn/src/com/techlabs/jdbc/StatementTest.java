package com.techlabs.jdbc;

import java.sql.*;

public class StatementTest {

	public static void main(String[] args) {
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:4040/test?characterEncoding=latin1&user=swabhav&password=swabhav");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("Select * from EMP");
//			System.out.println("EMPNO\tENAME\tJOB\t\tMGR\tHIREDATE\tSAL");
			while(rs.next()) {
				System.out.println(rs.getInt("EMPNO")+"\t"+rs.getString("ENAME")+"\t"+rs.getString("JOB")+"\t"+rs.getString("MGR")+"\t"+rs.getString("HIREDATE")+"\t"+rs.getString("SAL"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
