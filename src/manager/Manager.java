package manager;

import finance.Action;
import finance.Price;
import finance.Transaction;
import strategies.Strategy;
import strategies.StrategyMaster;
import scheduling.ScheduleManager;
import scheduling.Timer;

public class Manager extends ScheduleManager {
	boolean working = false;
	final int maxSecs = 16200;
	int secsWorked;
	int managerNum;
	String name;
	Strategy[] strategies;

	public Manager(String name, Strategy one, Strategy two, int num) {
		super(num);
		this.name = name;
		strategies = new Strategy[] { one, two };
		managerNum = num;
	}

	public Transaction act() {

		Transaction trans;

		if (this.isWorking()) {
			for (Strategy strategy : strategies) {

				Action act = StrategyMaster.getAction(strategy);

				this.getConnection().sendAction(act);

				trans = new Transaction(Timer.getTime(), Action.BUY,
						executedPrice, this, strategy);
			}
		}
		return trans;
	}

	public String toString() {
		return this.name;
	}

}
