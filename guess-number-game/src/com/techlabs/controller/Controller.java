package com.techlabs.controller;

import java.util.Scanner;

import com.techlabs.player.Machine;
import com.techlabs.player.Player;

public class Controller {
	@SuppressWarnings("resource")
	public int controllGame() {
		int step = 0;
		Machine mc = new Machine();
		Player player = new Player();
		Scanner sc = new Scanner(System.in);
		int machineinput = mc.getInputnumber();
		while(true) {
			System.out.println("Enter Number");
			player.setInputnumber(sc.nextInt());
			step++;
			if(player.getInputnumber() > machineinput){
				System.out.println("Greater");
				continue;
			}
			else if(player.getInputnumber() < machineinput){
				System.out.println("Less");
				continue;
			}
			if(player.getInputnumber() == machineinput);{
				break;
			}
		}
		return step;
	}
}
