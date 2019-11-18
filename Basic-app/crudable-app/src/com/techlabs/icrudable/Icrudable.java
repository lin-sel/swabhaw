package com.techlabs.icrudable;

public interface Icrudable {
	public String create(String data);
	public String read();
	public String update(String data);
	public String delete(String data);
}
