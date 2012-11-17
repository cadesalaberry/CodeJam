package finance;

import java.util.ArrayList;

public class TransactionRecord {
	
	private ArrayList<Transaction> record;
	
	public TransactionRecord() {
		record = new ArrayList<Transaction>();
	}
	
	public void addRecord(Transaction transaction){
		record.add(transaction);
	}
	
	public ArrayList<Transaction> getFullRecord(){
		return record;
	}
}
