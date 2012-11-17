package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import strategies.LWMA;

public class LWMATest {

	// THIS IS THE CORRECT SAMPLE PRICE !
	double[] samplePrice = { 61.590, 61.440, 61.320, 61.670, 61.920, 62.610,
			62.880, 63.060, 63.290, 63.320, 63.260, 63.120, 62.240, 62.190,
			62.890 };
	// VALUES HAVE BEEN CHECKED !!
	double[] correctValues = { 61.590, 61.490, 61.405, 61.511, 61.647, 61.988,
			62.351, 62.677, 62.965, 63.154, 63.230, 63.216, 62.893, 62.607,
			62.629 };

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

			actual = LWMA.getFastRunningAverage(listToPass);

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + correctValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(correctValues[time] == actual);
		}
	}

}
