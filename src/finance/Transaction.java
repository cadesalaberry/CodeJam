package finance;
import manager.Manager;
import strategies.Strategy;
import strategies.StrategyManager;


public class Transaction {

	int time;
	Action action;
	Price price;
	Manager manager;
	StrategyManager strategyManager;
	Strategy strategy;
	
	
	public Transaction(int time, Action action, Price price, Manager manager, StrategyManager strategyManager){
		
		this.time = time;
		this.action = action;
		this.price = price;
		this.manager = manager;
		this.strategyManager = strategyManager;
		
	}
	
public Transaction(int time, Action action, Price price, Manager manager, Strategy strategy){
		
		this.time = time;
		this.action = action;
		this.price = price;
		this.manager = manager;
		this.strategy = strategy;
		
	}
	
	public int getTime(){
		return time;
	}
	
	public Action getAction(){
		return action;
	}
	
	public Price getPrice(){
		return price;
	}
	
	public Manager getManager(){
		return manager;
	}
	
	public StrategyManager getStrategy(){
		return this.strategyManager;
	}
}
