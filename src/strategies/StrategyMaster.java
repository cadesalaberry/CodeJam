package strategies;

import java.util.LinkedList;
import java.util.List;

import finance.Action;

public class StrategyMaster {

	private static LinkedList<Double> priceHistory = new LinkedList<Double>();

	/**
	 * Gets a list of the last 'm' prices.
	 * 
	 * @param m
	 * @return
	 */
	public static List<Double> getLastPrices(int m) {
		if (priceHistory.size() < m) {
			return priceHistory;
		}
		return priceHistory.subList(0, m);
	}

	/**
	 * Adds a price to the Price History.
	 * 
	 * @param price
	 */
	public static void addPrice(double price) {

		priceHistory.addLast(price);

		if (priceHistory.size() > 50) {
			priceHistory.removeFirst();
		}
		List<Double> latest20 = getLastPrices(20);

		SMA.update(latest20);
		LWMA.update(latest20);
		EMA.update(latest20);
		TMA.update(latest20);

	}

	/**
	 * Decides which action to issue induced by the strategy.
	 * 
	 * @param strategy
	 * @return
	 */
	public static Action getAction(Strategy strategy) {

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
		default:
			return Action.DO_NOTHING;
		}
	}

	/**
	 * General method to compute the average of a list.
	 * 
	 * @param list
	 * @return
	 */
	public static double getAverage(List<Double> list) {
		double sum = 0.0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return round(sum / list.size());

	}

	/**
	 * General method to round a number (3 decimal places).
	 * 
	 * @param num
	 * @return
	 */
	public static double round(double num) {
		double result = num * 1000;
		result = Math.round(result);
		result = result / 1000;
		return result;
	}
}
