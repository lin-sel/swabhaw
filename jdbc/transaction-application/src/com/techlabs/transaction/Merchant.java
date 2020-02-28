package com.techlabs.transaction;

import java.sql.*;

public class Merchant {
	
private static Merchant instance;
	
	PreparedStatement addMerchantSt = null;
	
	public static Merchant getInstance() {
		if (instance == null)
			instance = new Merchant();
		return instance;
	}
	
	public int addMerchant(Connection c, int mid, String mname,
			double mbalance) throws SQLException {
		if (addMerchantSt == null) 
			addMerchantSt = c.prepareStatement(
				"insert into MERCHANT values(?, ?, ?)");
		addMerchantSt.clearParameters();
		addMerchantSt.setInt(1, mid);
		addMerchantSt.setString(2, mname);
		addMerchantSt.setDouble(3,  mbalance);
		return addMerchantSt.executeUpdate();
	}
	
	public ResultSet getMerchant(Connection c, int mid) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"select * from MERCHANT where mid=?");
		ps.setInt(1,  mid);
		if (ps.execute())
			return ps.getResultSet();
		return null;
	}
	
	public int purchase(Connection c, int mid, double amount) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"update MERCHANT set balance=balance+? where mid=?");
		ps.setDouble(1, amount);
		ps.setInt(2, mid);
		return ps.executeUpdate();
	}
	
	public void createTable(Connection c) throws SQLException {
		PreparedStatement ps = c.prepareStatement(
				"drop table if exists MERCHANT;");
		ps.execute();
		
		ps = c.prepareStatement(
				"create table if not exists MERCHANT("
				+ "mid int, mname varchar(20), balance decimal)");
		ps.execute();
	}

}
