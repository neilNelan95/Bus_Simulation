package com.busSimulation;

import java.util.concurrent.TimeUnit;

public class Bus implements Runnable {
	
	static int busId;
	static int stopId;
	static int numPassengers;
	static int travelTime;
	static int loadTime;
	
	
	

	public Bus(int id, int spaceId, int travel, int load) {
		busId = id;
		numPassengers = 0;
		travelTime = travel;
		loadTime = load;
		
		
	}
	
	
	
	
	
	

	
	public static int getBusId() {
		return busId;
	}








	public void printInfo() {
		
		System.out.println("Bus " + busId + ": " + numPassengers + " on the bus");
		

	}
	
	
	public String toString () {
		
		String blah = busId + " / " + numPassengers;
		
		return blah;
		
	}





	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
