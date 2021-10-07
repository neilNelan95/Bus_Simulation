package com.busSimulation;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BusStop {
	
	public static Bus currentBus;
	


	static int numRiders;
	
	
	static int stopId;
	static int nextStopId;
	static int prevStopId;
	
	
	
	static int passengerArriveFreqLow;
	static int passengerArriveFreqHigh;
	
	//Test Comment
	
	

	public BusStop(int id, int frequencyLow, int frequencyHigh, int totalStops) {
		
		currentBus = null;
		numRiders = 0;
		stopId = id;
		
		
		/*
		 * if (id == totalStops -1) nextStopId = 0; //Edge (no pun intended) cases
		 * 
		 * else nextStopId = id + 1;
		 * 
		 * 
		 * 
		 * if (id == 0) prevStopId = 14;
		 * 
		 * else prevStopId = id - 1;
		 */
		
			
		
		passengerArriveFreqLow = frequencyLow;
		passengerArriveFreqHigh = frequencyHigh;
		
	}
	
	
	
	public static Bus getCurrentBus() {
		return currentBus;
	}




	public static void setCurrentBus(Bus currentBus) {
		BusStop.currentBus = currentBus;
	}




	public static int getStopId() {
		return stopId;
	}


	public void printInfo () { // This is basically done
		
		System.out.println("Stop " + stopId + ": " + numRiders + " people waiting in queue.");
		
		if (currentBus == null) {
			System.out.println("Stop " + stopId + ": no bus currently parked.");
		}
		
		else {
			
			System.out.println("Stop " + stopId + ": bus " + currentBus.getBusId() + " is parked.");
			
		}
		
		
		
		
	}
	
	
	public void addToQueue() { //This method will periodically add passengers to the rider queue.
		
		
		
		
		
		Random random = new Random();
		
		int wait = ThreadLocalRandom.current().nextInt(passengerArriveFreqLow, passengerArriveFreqHigh + 1);
		
		try {
			TimeUnit.SECONDS.sleep(wait);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		numRiders++;
		
		//System.out.println("stop " + stopId + " has "+numRiders);
		
		
		
	}
	
	
	
	
	

}
