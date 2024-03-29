package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import strategies.EMA;

public class EMATest {

	/**
	 * Tests getSlowRunningAverage.
	 * 
	 * Might not be correct as the correct data was taken from
	 * fastRunningAverage.
	 * 
	 */
	@Test
	public void testGetSlowRunningAverageDouble() {

		double[] samplePrice = { 61.590, 61.440, 61.320, 61.670, 61.920,
				62.610, 62.880, 63.060, 63.290, 63.320, 63.260, 63.120, 62.240,
				62.190, 62.890 };
		double[] correctValues = { 61.590, 61.576, 61.551, 61.563, 61.597,
				61.693, 61.806, 61.926, 62.056, 62.176, 62.279, 62.359, 62.348,
				62.333, 62.386 };
		LinkedList<Double> listToPass = new LinkedList<Double>();
		double actual;

		System.out.println("=======SLOW=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < samplePrice.length; time++) {
			listToPass.add(samplePrice[time]);
			// Gets the value from our algorithm.
			actual = EMA.getSlowRunningAverage(listToPass);

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + correctValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(correctValues[time] == actual);
		}
	}

	/**
	 * Tests getSlowRunningAverage.
	 */
	@Test
	public void testGetFastRunningAverageDouble() {

		double[] samplePrice = { 61.590, 61.440, 61.320, 61.670, 61.920,
				62.610, 62.880, 63.060, 63.290, 63.320, 63.260, 63.120, 62.240,
				62.190, 62.890 };
		double[] correctValues = { 61.590, 61.540, 61.467, 61.534, 61.663,
				61.979, 62.279, 62.539, 62.790, 62.966, 63.064, 63.083, 62.802,
				62.598, 62.695 };

		double actual;
		LinkedList<Double> listToPass = new LinkedList<Double>();
		System.out.println("=======FAST=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < samplePrice.length; time++) {
			listToPass.add(samplePrice[time]);
			// Gets the value from our algorithm.
			actual = EMA.getFastRunningAverage(listToPass);

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + correctValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(correctValues[time] == actual);
		}
	}

}
