package com.techlabs.game.test;

import java.util.Scanner;

import com.techlabs.controller.Controller;

public class GameTest {

	public static void main(String[] args){
		Controller controller = new  Controller();
		Scanner sc = new Scanner(System.in);
		int choice;
		while(true){
			System.out.println("Enter Option...");
			System.out.println("1. Start Game.");
			System.out.println("2. Stop Game.");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				int step = controller.controllGame();
				System.out.println("win");
				System.out.println("You took "+step+" for win the game..");
				break;
			case 2:
				System.out.println("Game Closed.......");
				sc.close();
				System.exit(0);
				
			default:
				System.out.println("Wrong Choice Enter Again....");
			}
		}
	}
}
