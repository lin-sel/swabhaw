package com.techlabs.test.vehicle;

import com.techlabs.bike.Bike;
import com.techlabs.car.Car;
import com.techlabs.movable.Movable;
import com.techlabs.truck.Truck;

public class VehicleTest {

	public static void main(String[] args) {
		Bike bike = new Bike();
		Car car = new Car();
		Truck truck = new Truck();
		
		Movable[] move = {bike, car, truck};
		startRace(move);
	}
	
	public static void startRace(Movable [] move) {
		for(Movable object : move) {
			object.move();
		}
	}

}
