package strategies;

import java.util.List;

import finance.Action;

public final class LWMA extends StrategyManager {

	public static double getSlowRunningAverage(List list) {
		double numerator = 0,denominator = 0;

		for (int i = 0 ; i < (list.size());i++){
			denominator = denominator+ (i+1);
			numerator= numerator + ((double)(list.get(i))*(list.size()-i));
		}
		return (numerator/denominator);
	}

	public static double getFastRunnindAverage(List list) {
		return getSlowRunningAverage(list);
	}
	public static Action update(List<Double> lastPrices) {
		// TODO Auto-generated method stub
		return null;
	}
}
