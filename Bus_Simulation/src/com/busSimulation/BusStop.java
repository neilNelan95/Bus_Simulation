package com.busSimulation;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BusStop implements Runnable {
	
	
	static int stopId;

	static int numRiders;
	
	static int riderFrequency;
	
	
	//Test Comment
	
	

	public BusStop(int id, int riderRate) {
		
		stopId = id;
		numRiders = 0;
		riderFrequency = riderRate;
	
		
	}
	
	
	








	public static int getNumRiders() {
		return numRiders;
	}

	
	public static void addRider() {
		numRiders++;
	}




	public void printInfo () { // This is basically done
		
		
		
		
	}
	
	
	public void addToQueue() { //This method will periodically add passengers to the rider queue.
		
		
		
	}





	@Override
	public void run() {
		int arrivalTime = 0;
		
		while(true) {
			
		}
		
	}
	
	
	
	
	

}
