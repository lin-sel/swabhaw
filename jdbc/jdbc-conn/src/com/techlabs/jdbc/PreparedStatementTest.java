package com.techlabs.jdbc;

import java.sql.*;

public class PreparedStatementTest {

	public static void main(String[] args) {
		java.sql.Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?characterEncoding=latin1&user=swabhav&password=swabhav");
			java.util.Scanner sc = new java.util.Scanner(System.in);

			PreparedStatement stmt = conn.prepareStatement("select * from EMP where DEPTNO = ?"); 
			System.out.println("Enter Department Id for Search");
			stmt.setString(1,sc.nextLine());
			
			ResultSet rs = stmt.executeQuery();
			
			sc.close();
			
			while(rs.next()) {
				System.out.println(rs.getInt("EMPNO")+"\t"+rs.getString("ENAME")+"\t"+rs.getString("JOB")+"\t"+rs.getString("MGR")+"\t"+rs.getString("HIREDATE")+"\t"+rs.getString("SAL"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void createTable(){
		
	}

}
