package strategies;

import java.util.List;

import finance.Action;

public final class LWMA extends StrategyMaster {

	public static double getSlowRunningAverage(List<Double> list) {
		double numerator = 0,denominator = 0;

		for (int i = 1 ; i < (list.size()+1);i++){
			denominator = denominator+ (i);
			numerator= numerator + (list.get(i-1))*(i);

		}
		return round(numerator/denominator);
	}

	public static double getFastRunningAverage(List<Double> list) {
		return getSlowRunningAverage(list);
	}
	public static Action update(List<Double> lastPrices) {
		// TODO Auto-generated method stub
		return null;
	}

	public static double round(double num) {
		double result = num * 1000;
		result = Math.round(result);
		result = result / 1000;
		return result;
		}

	public static Action getAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
