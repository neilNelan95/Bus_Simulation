package com.busSimulation;

import java.util.concurrent.TimeUnit;

public class Bus {
	
	static int busId;
	static int numPassengers;
	static boolean isParked;
	static int currentStop;
	
	
	public static int getCurrentStop() {
		return currentStop;
	}

	public static void setCurrentStop(int currentStop) {
		Bus.currentStop = currentStop;
	}


	static int previousStop;
	static int nextStop;
	static int travelSpeed;
	static int loadSpeed;
	
	static BusStop[] busLoop;
	
	

	public Bus(int id, BusStop[] loop) {
		busId = id;
		numPassengers = 0;
		isParked = false;
		
		busLoop = loop;
		
	}
	
	public void loadBus (int passengerQueue) {
		
		int queue = passengerQueue;
		
		try {
			
			while (queue > 0) {
			
			TimeUnit.SECONDS.sleep(loadSpeed);
			numPassengers++;
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	void travelNext () {
		
		nextStop++;
		previousStop++;
		isParked = false;
		
	}

	public static int getBusId() {
		return busId;
	}

	public static void setBusId(int busId) {
		Bus.busId = busId;
	}

	public static int getNumPassengers() {
		return numPassengers;
	}

	public static void setNumPassengers(int numPassengers) {
		Bus.numPassengers = numPassengers;
	}

	public static boolean isParked() {
		return isParked;
	}

	public static void setParked(boolean isParked) {
		Bus.isParked = isParked;
	}


	public static int getPreviousStop() {
		return previousStop;
	}

	public static void setPreviousStop(int previousStop) {
		Bus.previousStop = previousStop;
	}

	public static int getNextStop() {
		return nextStop;
	}

	public static void setNextStop(int nextStop) {
		Bus.nextStop = nextStop;
	}
	
	
	public void printInfo() {
		
		System.out.println("Bus " + busId + ": " + numPassengers + " on the bus");
		
		if (isParked == true) System.out.println("Bus " + busId + ": currently at stop " + currentStop);
		
		else System.out.println("Bus " + busId + ": traveling from stop " + previousStop + " to stop " + nextStop);
		
	}
	

}
