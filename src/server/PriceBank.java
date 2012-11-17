package server;

import java.util.LinkedList;

import scheduling.Timer;

import finance.Price;

public class PriceBank {
	
	private static LinkedList<Price> safe;
	
	
	public PriceBank(){
		safe = new LinkedList<>();
	}
	
	/**
	 * Adds a Price to the 
	 * @param in
	 */
	public static void deposit(double in){
		
		safe.addLast(new Price(in, Timer.getTime()));
	}
	
	public static Price withdraw(){
		return safe.removeFirst();
	}
}
