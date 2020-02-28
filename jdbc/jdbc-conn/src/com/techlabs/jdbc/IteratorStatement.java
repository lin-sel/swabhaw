package com.techlabs.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IteratorStatement {

	public static void main(String[] args) {
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/test?characterEncoding=latin1&user=swabhav&password=swabhav");
			Statement statement = conn.createStatement();
			java.util.Scanner sc = new java.util.Scanner(System.in);
			System.out.println("Enter Department id");
			ResultSet rs = statement.executeQuery("Select * from EMP where DEPTNO = "+ sc.nextLine()); 
			while(rs.next()) {
				System.out.println(rs.getInt("EMPNO")+"\t"+rs.getString("ENAME")+"\t"+rs.getString("JOB")+"\t"+rs.getString("MGR")+"\t"+rs.getString("HIREDATE")+"\t"+rs.getString("SAL"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
