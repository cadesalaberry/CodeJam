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

	double[] correctValues = { 61.590, 61.553, 61.518, 61.515, 61.530, 61.570,
			61.683, 61.879, 62.128, 62.417, 62.691, 62.917, 63.040, 63.055,
			62.997 };

	@Test
	public void testGetFastRunnindAverage() {
		
		double actual;

		LinkedList<Double> listToPass = new LinkedList<Double>();

		System.out.println("=======FAST=======");

		// Parse the sampleData corresponding to time.
		for (int time = 0; time < samplePrice.length; time++) {

			listToPass.add(samplePrice[time]);

			if (listToPass.size() > 5) {
				listToPass.removeFirst();
			}

			// System.out.println(listToPass);

			actual = TMA.getFastRunningAverage(listToPass);

			System.out.print("Time\t: " + time);
			System.out.print("\tDesired: " + correctValues[time]);
			System.out.println("\tIs\t: " + actual);

			assertTrue(correctValues[time] == actual);
		}
	}

}
