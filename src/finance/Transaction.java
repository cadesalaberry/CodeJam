package finance;

import manager.Manager;
import strategies.Strategy;
import strategies.StrategyMaster;

public class Transaction {

	int time;
	Action action;
	Price price;
	Manager manager;
	StrategyMaster strategyManager;
	Strategy strategy;

	public Transaction(int time, Action action, Price price, Manager manager,
			StrategyMaster strategyManager) {

		this.time = time;
		this.action = action;
		this.price = price;
		this.manager = manager;
		this.strategyManager = strategyManager;

	}

	public Transaction(int time, Action action, Price price, Manager manager,
			Strategy strategy) {

		this.time = time;
		this.action = action;
		this.price = price;
		this.manager = manager;
		this.strategy = strategy;

	}
	/**
	 * Returns time of transaction.
	 * @return
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Return buy or sell.
	 * @return
	 */
	public Action getAction() {
		return action;
	}
	/**
	 * Returns price of transaction.
	 * @return
	 */
	public Price getPrice() {
		return price;
	}
	/**
	 * Returns manager responsible for calling the transaction.
	 * @return
	 */
	public Manager getManager() {
		return manager;
	}
	/**
	 * Returns strategy used.
	 * @return
	 */
	public Strategy getStrategy() {
		return this.strategy;
	}
	/**
	 * Returns the strategy master of the transaction.
	 * @return
	 */
	public StrategyMaster getStrategyManager() {
		return this.strategyManager;
	}
}
