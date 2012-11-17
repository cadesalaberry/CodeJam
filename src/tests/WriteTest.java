package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import manager.Manager;

import org.junit.Test;

import strategies.Strategy;

import finance.Action;
import finance.Price;
import finance.Transaction;
import reporting.Write;

public class WriteTest {

	@Test
	public void testWrite() {

		Transaction t1 = new Transaction(8004, Action.BUY, new Price(120, 8004),
				new Manager("Manager1", Strategy.EMA, Strategy.NOTHING, 1),
				Strategy.EMA);
		Transaction t2 = new Transaction(9589, Action.SELL, new Price(122, 9589),
				new Manager("Manager2", Strategy.LWMA, Strategy.NOTHING, 2),
				Strategy.LWMA);
		Transaction t3 = new Transaction(16542, Action.BUY, new Price(118, 16542),
				new Manager("Manager1", Strategy.TMA, Strategy.NOTHING, 3),
				Strategy.TMA);

		ArrayList<Transaction> arrayList = new ArrayList<Transaction>();

		arrayList.add(t1);
		arrayList.add(t2);
		arrayList.add(t3);

		Write report = new Write(arrayList);
		report.writeData();

		assertTrue(filesMatch());
	}

	public boolean filesMatch() {

		String json = fileToString("./codejam.json");
		String correct = fileToString("./correct.json");
		
		return (correct.equals(json));
	}
	
	public String fileToString(String filename){
		
		String toReturn = "";
		String temp = "";
		
		// Reads the file with corresponding filename.
		File file = new File(filename);
		
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			
			while ((temp = buffer.readLine()) != null)
				toReturn += temp;
			
			// Properly closes the file.
			buffer.close();
			
			// Prints the file as a String.
			// System.out.println("\n" + correct);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
}
