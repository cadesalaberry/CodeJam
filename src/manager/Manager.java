package manager;

import finance.Action;
import finance.Transaction;
import strategies.Strategy;
import strategies.StrategyManager;

public class Manager {
boolean working = false;
final int maxSecs=16200;
int secsWorked;
String name;
Strategy[] strategies;    

public Manager(String name, Strategy one, Strategy two) {
	this.name = name;
	strategies = new Strategy[]{one, two}; 
}

public Manager(String name, Strategy one) {
	this.name = name;
	strategies = new Strategy[]{one};
}

public Transaction tryBuyOrSell() {
	if(working) {
		for(int i=0;i<strategies.length;i++) {
			Action temp = StrategyManager.getAction(strategies[i]);
			
			if(temp == Action.BUY) {
				return buy(strategies[i]);
			}
			else if(temp == Action.SELL) {
				return sell(strategies[i]);
			}
		}
	}
}

public Transaction buy(Strategy strategy) {
	double executedPrice;
	executedPrice = ServerConnection.executeBuy();
	Transaction trans = new Transaction(time,Action.BUY,executedPrice,this.managerName,strategy);
	return trans;
}

public Transaction sell(Strategy strategy) {
	double executedPrice = ServerConnection.executeSell();
	Transaction trans = new Transaction(Timer.getTime(), Action.SELL, executedPrice, managerName, strategy);
	return trans;
}

}
