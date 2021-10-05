package com.busSimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		
		busStops = new BusStop[numStops];
		
		
		//Creation of Buses
		
		
		initializeStops(numStops);
		
		busStops[0].addToQueue();
		busStops[1].addToQueue();
		
		
		
		buses = new ArrayList<>();
		
		initializeBuses();
		
		
		
		

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
			buses.get(i).printInfo();
			i++;
			
		}
		
	}
	
	
	public void populateStops() {
		
		
	}
	
	
	
	
	
	
	

}
