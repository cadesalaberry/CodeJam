
public class Transaction {

	int time;
	Action action;
	Price price;
	
	
	public Transaction(int time, Action action, Price price){
		
		this.time = time;
		this.action = action;
		this.price = price;
		
	}
}
