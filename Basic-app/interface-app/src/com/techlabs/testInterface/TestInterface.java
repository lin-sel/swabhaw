package com.techlabs.testInterface;

import com.techlabs.boy.Boy;
import com.techlabs.emotional.Iemotional;
import com.techlabs.man.Man;
import com.techlabs.manner.Imanner;

public class TestInterface {

	public static void main(String[] args) {
		Man man = new Man();
		Boy boy = new Boy();
		
		atTheParty(man);
		atTheParty(boy);
		atTheMovieHall(boy);
		atTheMovieHall(man);
	}
	
	public static void atTheMovieHall(Iemotional object) {
		object.cry();
		object.laugh();
	}
	
	public static void atTheParty( Imanner object) {
		object.depart();
		object.wish();
	}

}
