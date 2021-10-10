package com.busSimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BusApp {

	// Variables set from properties file

	static int numStops;
	static int travelTime;
	static int numBuses;

	static int boardingSpeed; // Average time it takes (in seconds) for a passenger to board a bus

	static int queueAddFreqLow; // Average time it takes (in seconds) for a new passenger to join a waiting
										// queue
	static int queueAddFreqHigh; // Average time it takes (in seconds) for a new passenger to join a waiting
										// queue

	static int runTime;// Runtime in minutes
	
	static long startTime;
	
	

	static int currentTime;
	// Creation of Bus arraylist. Size is set by numStops attribute.
	
	
	private static ArrayList<BusStop> stops;
	private static ArrayList<Bus> buses;
	
	public static void initialize(int numBuses, int numStops, int travel, int boardTime, int arrivalLow, int arrivalHigh, int totalTime) {
		
		stops = new ArrayList<BusStop>();
		buses = new ArrayList<Bus>();
		
		startTime = System.nanoTime();
		
		Bus myBus;
		BusStop myStop;
		
		
		for (int i = 0; i < numStops; i++) {
			myStop = new BusStop(i, arrivalLow, arrivalHigh);
			stops.add(myStop);
		}
		
		
		
		for (int i = 0; i < numBuses; i++) {
			
			myBus = new Bus(i, (numStops/numBuses)*i, travel, boardTime, stops);
			buses.add(myBus);
			
			
		}
		
		
		
		
		
		
	}
	
	
	public void printBuses (File file) {
		
	}
	
	public static void consoleBusesAndStops() {
		
		for (int i = 0; i < stops.size(); i++ ) {
			
			System.out.println(stops.get(i).stopInfo());
		}
		
		for (int i = 0; i < buses.size(); i++) {
			System.out.println(buses.get(i).busInfo());
		}
		
	}
	
	
	

	public static void main(String[] args) {
		File file = new File("src/properties.txt");

		Scanner stdin;

		try { // Reading of property file variables
			stdin = new Scanner(file);

			numStops = stdin.nextInt();
			travelTime = stdin.nextInt();
			numBuses = stdin.nextInt();
			boardingSpeed = stdin.nextInt();
			queueAddFreqLow = stdin.nextInt();
			queueAddFreqHigh = stdin.nextInt();
			runTime = stdin.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize(numBuses, numStops, travelTime, boardingSpeed, queueAddFreqLow, queueAddFreqHigh, runTime);
		
		System.out.println("Application has started.");
		
		for (int i = 0; i < stops.size(); i++) {
			new Thread(stops.get(i)).start();
		}
		 
		for (int i = 0; i < buses.size(); i++) {
			new Thread(buses.get(i)).start();
		}
		
		
		while(currentTime < runTime) {
			
			try {
				Thread.sleep(10000);
				consoleBusesAndStops();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	

	
	
	
	
}



