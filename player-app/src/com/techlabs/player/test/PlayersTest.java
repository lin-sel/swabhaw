package com.techlabs.player.test;

import com.techlabs.player.Player;

public class PlayersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player player1 = new Player(101,20,"Alex");
		Player player2 = new Player(101,23,"Jack");
		System.out.println(player1.getAge());
		
		// Elder Player.
		int ageresult = player1.whoIsElder(player2); 
		if(ageresult == 0) {
			System.out.println("Both are of same age.");
		}
		else if(ageresult == 1) {
			System.out.println(player1.getName()+" are Elder than "+player2.getName());
		}
		else {
			System.out.println(player2.getName()+" are Elder than "+player1.getName());
		}
		
		// Check Object Equality.
		Player player3 = player1;
		System.out.println(player1.hashCode());
		System.out.println(player2.hashCode());
		System.out.println(player3.hashCode());
	}

}
