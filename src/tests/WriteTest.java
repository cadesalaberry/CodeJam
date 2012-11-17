package tests;

import static org.junit.Assert.*;

import manager.Manager;

import org.junit.Test;

import strategies.Strategy;

import finance.Action;
import finance.Price;
import finance.Transaction;

public class WriteTest {

	@Test
	public void testWrite() {
		
		Transaction t1 = new Transaction(2000, Action.BUY, new Price(20), new Manager("bob", Strategy.EMA, Strategy.NOTHING), Strategy.EMA);
		
		fail("Not yet implemented");
	}

}
