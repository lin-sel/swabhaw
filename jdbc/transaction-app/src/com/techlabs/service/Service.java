package com.techlabs.service;

import java.sql.SQLException;
import java.sql.Statement;

import com.techlabs.model.Model;

public class Service {
	private java.sql.Connection conn;
	private Model customer;
	private Model marchant;
	private Statement st;
	
	Service(java.sql.Connection conn) throws SQLException{
		this.conn = conn;
		this.init();
	}
	
	public void init() throws SQLException{
		if (this.customer == null && this.marchant == null && this.customer == null) {
			this.customer = new Model();
			this.marchant = new Model();
			this.st = this.conn.createStatement();
		}
	}
	
	private void createTable() throws SQLException {
		this.executeQuery("create table customer ( id int, name varchar(20), balance int)");
		this.executeQuery("create table marchant ( id int, name varchar(20), balance int)");
	}
	
	private void executeQuery(String statement) throws SQLException {
		this.st.executeQuery(statement);
	}

}
