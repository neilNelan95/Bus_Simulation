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

	// Creation of Bus array. Size is set by numStops attribute.
	
	
	

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
		
		
		
		
		
		//System.out.println(myBuses[1].getBusId());
		//System.out.println(myBuses[4].getBusId());
		 

	}
	
	
	
	

	 
	

	/*
	 * public static void populateStops() { //Populate all available buses at random
	 * stops in the queue.
	 * 
	 * 
	 * int i = 0;
	 * 
	 * while (i < buses.size()) {
	 * 
	 * Bus bus = buses.get(i); //Pick bus from array list
	 * 
	 * boolean busIsPlaced = false;
	 * 
	 * while (busIsPlaced == false) {
	 * 
	 * int initialStop = ThreadLocalRandom.current().nextInt(0, numStops); //
	 * Generate a random stop ID
	 * 
	 * //System.out.println("random stop generated: " + initialStop);
	 * 
	 * if (!(busStops[initialStop].getCurrentBus() instanceof Bus)) { // If stop
	 * doesn't have a bus, park it there, // otherwise keep looking for an empty
	 * stop.
	 * 
	 * busStops[initialStop].setCurrentBus(bus); System.out.println(); busIsPlaced =
	 * true; i++;
	 * 
	 * 
	 * }
	 * 
	 * else bus.setIsParked(false);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

}
