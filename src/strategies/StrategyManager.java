package strategies;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StrategyManager {

	private LinkedList<Double> priceHistory;

	public static int getSlowRunningAverage() {
		return -1;
	}

	public static int getFastRunnindAverage() {
		return -1;
	}

	/**
	 * Gets a list of the last 'm' prices.
	 * 
	 * @param m
	 * @return
	 */
	public List<Double> getLastPrices(int m) {

		return priceHistory.subList(0, m);
	}

	/**
	 * Adds a price to the Price History.
	 * 
	 * @param price
	 */
	public void addPrice(double price) {

		priceHistory.addLast(price);
	
		if (priceHistory.size() > 50) {
			priceHistory.removeFirst();
		}
		
		SMA.update(getLastPrices(20));
		LWMA.update(getLastPrices(20));
		EMA.update(getLastPrices(20));
		TMA.update(getLastPrices(20));
		
	}

	public Action getAction(Strategy strategy) {

		switch (strategy) {
		case SMA: {
			return SMA.getAction();
		}
		case LWMA: {
			return LWMA.getAction();
		}
		case EMA: {
			return EMA.getAction();
		}
		case TMA: {
			return TMA.getAction();
		}
		}
		return null;
	}
}
