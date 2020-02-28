package com.techlabs.transaction;

import java.sql.*;

public class Customer {
	
	private static Customer instance;
	
	public static Customer getInstance() {
		if (instance == null)
			instance = new Customer();
		return instance;
	}
	
	public int addCustomer(Connection c, int cid, String cname, double cbalance) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"insert into CUSTOMERS values(?, ?, ?)");
		ps.setInt(1, cid);
		ps.setString(2, cname);
		ps.setDouble(3,  cbalance);
		return ps.executeUpdate();
	}
	
	public ResultSet getCustomers(Connection c, int cid) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"select * from CUSTOMERS where cid=?");
		ps.setInt(1,  cid);
		if (ps.execute())
			return ps.getResultSet();
		return null;
	}
	
	public int purchase(Connection c, int cid, double amount) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"update CUSTOMERS set balance=balance-? where cid=?");
		ps.setDouble(1, amount);
		ps.setInt(2, cid);
		return ps.executeUpdate();
	}
	
	public void createTable(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"drop table if exists CUSTOMERS;");
		ps.execute();
		
		ps = c.prepareStatement(
				"create table if not exists CUSTOMERS("
				+ "cid int, cname varchar(20), balance decimal)");
		ps.execute();
	}

}
