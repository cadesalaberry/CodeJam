package strategies;

import java.util.List;

import finance.Action;

public final class LWMA extends StrategyMaster {
	static double currentSlow;
	static double currentFast;
	static double previousSlow;
	static double previousFast;

	public static double getSlowRunningAverage(List<Double> list) {
		double numerator = 0, denominator = 0;

		for (int i = 1; i < (list.size() + 1); i++) {
			denominator = denominator + (i);
			numerator = numerator + (list.get(i - 1)) * (i);

		}
		return updateSlowValue(round(numerator / denominator));
	}

	private static double updateSlowValue(double newValue) {
		previousSlow = currentSlow;
		currentSlow = newValue;
		return currentSlow;
	}

	private static double updateFastValue(double newValue) {
		previousFast = currentFast;
		currentFast = newValue;
		return currentFast;
	}

	public static double getFastRunningAverage(List<Double> list) {
		double numerator = 0, denominator = 0;

		for (int i = 1; i < (list.size() + 1); i++) {
			denominator = denominator + (i);
			numerator = numerator + (list.get(i - 1)) * (i);

		}

		return updateFastValue(getSlowRunningAverage(list));
	}

	public static Action update(List<Double> lastPrices) {
		getSlowRunningAverage(lastPrices);
		getFastRunningAverage(lastPrices);
		return getAction();
	}

	public static Action getAction() {

		if (currentFast > currentSlow && previousFast <= previousSlow) {
			return Action.BUY;
		} else if (currentFast < currentSlow && previousFast >= previousSlow) {
			return Action.SELL;
		}
		return Action.DO_NOTHING;
	}
}
