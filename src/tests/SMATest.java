package tests;

import strategies.*;

import static org.junit.Assert.*;

import org.junit.Test;

import strategies.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SMATest {

	// THIS IS THE CORRECT SAMPLE PRICE !
	double[] samplePrice = { 61.590, 61.440, 61.320, 61.670, 61.920, 62.610,
			62.880, 63.060, 63.290, 63.320, 63.260, 63.120, 62.240, 62.190,
			62.890 };

	// CORRECT VALUES HAVE BEEN RE-CHECKED !
	double[] correctValues = { 61.590, 61.515, 61.450, 61.505, 61.588, 61.792,
			62.080, 62.428, 62.752, 63.032, 63.162, 63.210, 63.046, 62.826,
			62.740 };

	/**
	 * Tests getSlowRunningAverage.
	 * 
	 * Might not be correct as the correct data was taken from
	 * fastRunningAverage.
	 * 
	 */
	@Test
	public void testGetSlowRunningAverageList() {

		double actual;

		LinkedList<Double> listToPass = new LinkedList<Double>();

		System.out.println("=======SLOW=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < 15; time++) {

			listToPass.add(samplePrice[time]);

			if (listToPass.size() > 20) {
				listToPass.removeFirst();
			}

			actual = SMA.getSlowRunningAverage(listToPass);

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + correctValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(correctValues[time] == actual);
		}
	}

	@Test
	public void testGetFastRunnindAverageList() {

		double actual;

		LinkedList<Double> listToPass = new LinkedList<Double>();

		System.out.println("=======FAST=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < samplePrice.length; time++) {

			listToPass.add(samplePrice[time]);

			if (listToPass.size() > 5) {
				listToPass.removeFirst();
			}
			
			System.out.println(listToPass);
			
			actual = SMA.getFastRunningAverage(listToPass);

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + correctValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(correctValues[time] == actual);
		}
	}

	@Test
	public void testGetAction() {
		fail("Not yet implemented");
	}

}
