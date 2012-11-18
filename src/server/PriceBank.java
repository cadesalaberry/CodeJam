package server;

import java.util.LinkedList;

import scheduling.Timer;

import finance.Price;

public class PriceBank {

	private static LinkedList<Price> safe;
	
	/**
	 * Creates a new bank initialasing a safe.
	 */
	public PriceBank() {
		safe = new LinkedList<>();
	}

	/**
	 * Adds a Price to the bank.
	 *
	 * @param in
	 */
	public static void deposit(double in) {

		safe.addLast(new Price(in, Timer.getTime()));
	}
	
	/**
	 * Removes first price of the list.
	 * @return
	 */
	public static Price withdraw() {
		return safe.removeFirst();
	}
}
