package com.busSimulation;

import java.util.ArrayList;

public class BusLoop {
	
	private static int totalStops;
	private static int time;
	private static int totalBuses;

	private static int passBoardingSpeed; // Average time it takes (in seconds) for a passenger to board a bus

	private static int queueAddFreqLow; // Average time it takes (in seconds) for a new passenger to join a waiting
										// queue
	private static int queueAddFreqHigh; // Average time it takes (in seconds) for a new passenger to join a waiting
										// queue
	
	private static Bus[] buses;
	
	private static BusStop[] busStops;


	
	public BusLoop(int numStops,int travelTime, int numBuses, int boardingSpeed, int lowAddFreq, int highAddFreq) {
		
		totalStops = numStops;
		
		time = travelTime;
		
		totalBuses = numBuses;
		
		passBoardingSpeed = boardingSpeed;
		
		queueAddFreqLow = lowAddFreq;
		
		queueAddFreqHigh = highAddFreq;
		
		
		
		
		buses = new Bus[numBuses];
		
		int i = 0;

		while (i < numBuses) {

			buses[i] = new Bus(i);
			buses[i].printInfo();
			i++;

		}
		
		
		busStops = new BusStop[numStops];
		
		
		
		int j = 0;
		
		while (j < totalStops) {
			
			BusStop stop = new BusStop(i, queueAddFreqLow,queueAddFreqHigh, totalStops);
			
			busStops[j] = stop;
			//myList.get(i).printInfo();
			j++;
			
			
		}
		
		
	
		}
	


	public BusStop[] initializeStops() {
		
		BusStop[] stops = new BusStop[totalStops];
		
		int i = 0;
		
		while (i < totalStops) {
			
			BusStop stop = new BusStop(i, queueAddFreqLow,queueAddFreqHigh, totalStops);
			
			stops[i] = stop;
			//myList.get(i).printInfo();
			i++;
			
			
		}
		
		return stops;
		
	}
	
	public static Bus[] getBuses() {
		return buses;
	}



	public static void setBuses(Bus[] buses) {
		BusLoop.buses = buses;
	}



	public static BusStop[] getBusStops() {
		return busStops;
	}



	public Bus[] initializeBuses() {
		
		Bus[] buses = new Bus[totalBuses];
		
		int i = 0;

		while (i < totalBuses) {
			
			Bus bus = new Bus(i);
			

			buses[i] = bus;
			//myList.get(i).printInfo();
			i++;

		}
		
		return buses;
	}
	
	
	

}
