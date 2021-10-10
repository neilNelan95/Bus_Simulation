package com.busSimulation;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Bus implements Runnable {
	
	static int busId;
	static int currentStopId;
	static int numPassengers;
	static int travelTime; // time in minutes
	static int loadTime; // time in seconds
	
	static ArrayList<BusStop> stopList;
	
	
	
	

	public Bus(int id, int spaceId, int travel, int load, ArrayList<BusStop> list) {
		busId = id;
		currentStopId = spaceId;
		numPassengers = 0;
		travelTime = travel;
		loadTime = load;
		stopList = list;
		
		
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

	
	public void boarding (ArrayList<BusStop> stopList) {
		
		stopList.get(currentStopId).setRiders(-1); // decrements the # of passengers at a stop
		
	}
	
	
	
	public void arriving (ArrayList<BusStop> stopList) {
		
		if (currentStopId == stopList.size() - 1) {
			currentStopId = 0;
		}
		
		else {
			currentStopId ++;
			System.out.println("Bus " + busId + " arrives at stop " + currentStopId);
		}
		
	}




	@Override
	public void run() {
		
		int actionTime = 0;
		
		while (true) {
			
			try {
			
			while (stopList.get(currentStopId).getNumRiders() > 0) {
				boarding(stopList);
				
				actionTime = (loadTime * 1000); //Waiting time in milliseconds
				Thread.sleep(actionTime);
			}
			
			actionTime = (travelTime * 1000 * 60); //travel time converted from minutes to milliseconds
			Thread.sleep(actionTime);
			arriving(stopList);
			}
			
			catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}

	
	public String busInfo () {
		
		String myString = "Bus " + busId + " is at stop " + currentStopId;
		return myString;
	}

}
