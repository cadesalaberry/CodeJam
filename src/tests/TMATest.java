package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import strategies.TMA;

public class TMATest {

	// THIS IS THE CORRECT SAMPLE PRICE !
	double[] samplePrice = { 61.590, 61.440, 61.320, 61.670, 61.920, 62.610,
			62.880, 63.060, 63.290, 63.320, 63.260, 63.120, 62.240, 62.190,
			62.890 };

	double[] fastCorrectValues = { 61.590, 61.553, 61.518, 61.515, 61.530,
			61.570, 61.683, 61.879, 62.128, 62.417, 62.691, 62.917, 63.040,
			63.055, 62.997 };
	double[] slowCorrectValues = { 61.590, 61.553, 61.518, 61.515, 61.530,
			61.568, 61.618, 61.673, 61.732, 61.789, 61.845, 61.896, 61.937,
			61.972, 62.004 };

	@Test
	public void testGetFastRunningAverage() {

		double actual;

		LinkedList<Double> listToPass = new LinkedList<Double>();

		System.out.println("=======FAST=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < samplePrice.length; time++) {

			listToPass.add(samplePrice[time]);

			actual = TMA.getFastRunningAverage(listToPass);
			// actual = TMA.getFastRunningAverage(TMA.getSMAValues());

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + fastCorrectValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(fastCorrectValues[time] == actual);
		}
	}

	@Test
	public void testGetSlowRunningAverage() {

		double actual;

		LinkedList<Double> listToPass = new LinkedList<Double>();

		System.out.println("=======SLOW=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < samplePrice.length; time++) {

			listToPass.add(samplePrice[time]);

			actual = TMA.getSlowRunningAverage(listToPass);
			// actual = TMA.getFastRunningAverage(TMA.getSMAValues());

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + slowCorrectValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(slowCorrectValues[time] == actual);
		}
	}
}
