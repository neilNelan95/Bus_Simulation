package com.busSimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class BusApp {
	
	
	//Variables set from properties file
	
	static int numStops;
	static int travelDistance;
	static int numBuses;
	static int travelSpeed;
	
	
	static int boardingSpeed; //Average time it takes (in seconds) for a passenger to board a bus
	
	
	
	static int queueAddFrequencyLow; //Average time it takes (in seconds) for a new passenger to join a waiting queue
	static int queueAddFrequencyHigh; //Average time it takes (in seconds) for a new passenger to join a waiting queue
	
	
	static int runTime;//Runtime in minutes
	
	
	//Creation of Bus array. Size is set by numStops attribute.
	
	static BusStop[] busStops;
	
	
	static ArrayList<Bus> buses;


	public static void main(String[] args) {
		File file = new File("src/properties.txt");
		
		Scanner stdin;
		
		try { //Reading of property file variables
			stdin = new Scanner(file);
			
			numStops = stdin.nextInt();
			travelDistance = stdin.nextInt();
			numBuses = stdin.nextInt();
			travelSpeed = stdin.nextInt();
			boardingSpeed = stdin.nextInt();
			queueAddFrequencyLow = stdin.nextInt();
			queueAddFrequencyHigh = stdin.nextInt(); 
			runTime = stdin.nextInt(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		busStops = new BusStop[numStops]; // This needs to happen before buses are initialized
		
		
		//Creation of Buses
		
		
		initializeStops(numStops);
		
		
		
		buses = new ArrayList<>();
		
		initializeBuses(); //We create an array list of buses which houses unique bus objects.
		//We will take copies of these buses and place them within each stop.
		
		//The arraylist will be disregarded afterwards.
		
		populateStops();
		
		/*
		 * for (int i = 0; i < numStops; i ++) {
		 * 
		 * busStops[i].printInfo(); }
		 */
		
		
		

	}
	
	
	
	
	public static void initializeStops(int numStops) {
		
			int i = 0;
		
		while (i < numStops) {
			
			busStops[i] = new BusStop(i,queueAddFrequencyLow, queueAddFrequencyHigh, numStops);
			
			//busStops[i].printInfo();
			
			i++;
			
			
		}
		
	}
	
	
	public static void initializeBuses() {
		
		int i = 0;
		
		while (i < numBuses) {
			
			buses.add(i, new Bus(i, busStops));
			//buses.get(i).printInfo();
			i++;
			
		}
		
	}
	
	
	public static void populateStops() {
		
		for (int i = 0; i < numBuses; i++) {
			
			Bus bus = buses.get(i);
			
			while (bus.isParked == false) {
				
				int initialStop = ThreadLocalRandom.current().nextInt(0, numStops); //Generate a random stop ID
				
					if (busStops[i].getCurrentBus() == null) { //If stop doesn't have a bus, park it there, otherwise keep looking for an empty stop.
						
						busStops[i].setCurrentBus(bus);
						bus.setIsParked(true);
						
					}
					
					else bus.setIsParked(false);
				
			}
			
			
		}
		
		
	}
	
	
	
	
	
	
	

}
