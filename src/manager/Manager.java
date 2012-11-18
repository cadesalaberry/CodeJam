package manager;

import finance.Action;
import finance.Price;
import finance.Transaction;
import strategies.Strategy;
import strategies.StrategyMaster;
import scheduling.ScheduleManager;
import scheduling.Timer;
import server.Connection;

public class Manager extends ScheduleManager {

	boolean working = false; // Whether or not the manager is working
	int secsWorked; // Number of seconds worked
	int managerID; // Identiication number of manager
	String name; // Name of manager

	public Manager(String name, Strategy one, Strategy two, int iD) {

		super(one, two, iD);// Assigns 2 strategies that the manager is
							// responsible for and its ID from super class
		this.name = name;// Assigns the mamager name
		managerID = iD;// Assigns ID for manager
	}

	/**
	 * Decides rather to buy or sell with respect to the different strategies
	 * associated with the manager.
	 * 
	 * @param price
	 * @return
	 */
	public Transaction act(Price price) {

		Transaction trans;
		int time = Timer.getTime();
		// Attempts only if manager is not on break, or home
		// and is currently on shift
		if (this.isWorking()) {

			// Goes through both strategies
			for (Strategy strategy : this.getStrategies()) {

				// Determines buy or sell depending on strategy
				Action act = StrategyMaster.getAction(strategy);
				// Sends action to server
				Connection.sendAction(act);
				// Creates new transaction
				trans = new Transaction(time, act, price, this, strategy);
				return trans;
			}
		}
		// Returns null if neither buy nor sell is needed
		return null;
	}

	/**
	 * Prints name of manager
	 */
	public String toString() {
		return this.name;
	}

}
