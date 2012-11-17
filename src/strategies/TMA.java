package strategies;

import java.util.List;

import finance.Action;

public class TMA extends StrategyMaster {
	static double slowTmaValue;
	static double fastTmaValue;

	public static double getSlowRunningAverage(List<Double> list) {
		double denominator = list.size();
		double numerator = 0;
		for (int i = 1; i < (list.size() + 1); i++) {
			List<Double> tempList = list.subList(0, i);
			numerator = numerator + SMA.getSlowRunningAverage(tempList);
		}
		return round(numerator / denominator);
	}

	public static double getFastRunningAverage(List<Double> list) {
		double denominator = list.size();
		double numerator = 0;
		for (int i = 1; i < (list.size() + 1); i++) {
			List<Double> tempList = list.subList(0, i);
			numerator = numerator + SMA.getFastRunningAverage(tempList);
		}
		return round(numerator / denominator);
	}

	public static Action update(List<Double> lastPrices) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Action getAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
