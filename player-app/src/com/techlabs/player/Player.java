package com.techlabs.player;

public class Player {
	private int id;
	private String name;
	private int age;
	
	public Player(int id, int age, String name){
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int whoIsElder(Player pla) {
		if(this.age > pla.age) {
			return 1;
		}
		else if(this.age < pla.age) {
			return -1;
		}
		return 0;
	}
	
}
