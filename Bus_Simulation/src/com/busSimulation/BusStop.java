package com.busSimulation;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class BusStop implements Runnable {
	
	
	static int stopId;

	static int numRiders;
	
	static int riderFrequencyLow;
	
	static int riderFrequencyHigh;
	
	
	//Test Comment
	
	

	public BusStop(int id, int riderRateLow, int riderRateHigh) {
		
		stopId = id;
		numRiders = 0;
		riderFrequencyLow = riderRateLow;
		riderFrequencyHigh = riderRateHigh;
		
	}
	
	
	








	public static int getNumRiders() {
		return numRiders;
	}

	
	public static void setRiders(int i) {
		numRiders+= i;
	}




	public void printInfo () { // This is basically done
		
		
		
		
	}
	





	@Override
	public void run()  {
		int arrivalTime = 0;
		
		while(true) {
			try {
				
			arrivalTime = randomWaitTime(riderFrequencyLow, riderFrequencyHigh) * 1000 * 60; //Random number (user selects # minutes) gets converted to seconds.
			Thread.sleep(arrivalTime);
			setRiders(1);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static int randomWaitTime(int freqLow, int freqHigh) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(freqLow, freqHigh + 1);
      
        return randomNum;
    }
	
	public String stopInfo () {
		
		String myString = "Stop " + stopId + " has " + numRiders + " people in queue.";
		return myString;
	}
	
	
	
	
	

}
