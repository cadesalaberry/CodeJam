package strategies;


import java.util.LinkedList;
import java.util.List;

public class StrategyManager {

	private LinkedList<Double> priceHistory;

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
		List<Double> latest20 = getLastPrices(20);
		
		SMA.update(latest20);
		LWMA.update(latest20);
		EMA.update(latest20);
		TMA.update(latest20);
		
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
	public static double getAverage(List<Double> list){
		double sum=0.0;
		for(int i = 0; i < list.size(); i++){
			sum +=list.get(i);
		}
		return round(sum/list.size());

	}

	public static double round(double num) {
		double result = num * 1000;
		result = Math.round(result);
		result = result / 1000;
		return result;
		}
}
