package strategies;

import java.util.List;

import finance.Action;

public class SMA extends StrategyMaster{
	static double slowPastSma;
	static double fastPastSma;
	static double slowSmaValue;
	static double fastSmaValue;
	static double lastFastValue;
	static double lastSlowValue;
	static double currentSlow;
	static double currentFast;
	static double previousSlow;
	static double previousFast;

	public static double getSlowRunningAverage(List<Double> list) {
		if (list.size() <= 20) {
			slowSmaValue = getAverage(list);
			slowPastSma = slowSmaValue;
			lastSlowValue = list.get(list.size() - 1);
			return updateSlowValue(round(slowSmaValue));
		}
		slowSmaValue = (slowPastSma - (lastSlowValue / 20.0) + (list.get(0)) / 20.0);
		slowPastSma = round(slowSmaValue);
		lastSlowValue = round(list.get(list.size() - 1));
		return updateSlowValue(round(slowSmaValue));
	}

	public static double getFastRunningAverage(List<Double> list) {

		if (list.size() <= 5) {
			fastSmaValue = getAverage(list);
			fastPastSma = fastSmaValue;
			lastFastValue = list.get(list.size() - 1);
			return updateFastValue(round(fastPastSma));
		}

		fastSmaValue = (fastPastSma - round((lastFastValue / 5.0)) + round((list
				.get(0)) / 5.0));
		fastPastSma = fastSmaValue;
		lastFastValue = list.get(list.size() - 1);
		return updateFastValue(round(fastSmaValue));
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
