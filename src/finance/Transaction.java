package finance;
import manager.Manager;
import strategies.StrategyManager;


public class Transaction {

	int time;
	Action action;
	Price price;
	Manager manager;
	StrategyManager strategy;
	
	
	public Transaction(int time, Action action, Price price, Manager manager, StrategyManager strategy){
		
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
		return this.strategy;
	}
}
