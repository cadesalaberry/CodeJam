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

	public int getTime() {
		return time;
	}

	public Action getAction() {
		return action;
	}

	public Price getPrice() {
		return price;
	}

	public Manager getManager() {
		return manager;
	}

	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public StrategyMaster getStrategyManager() {
		return this.strategyManager;
	}
}
