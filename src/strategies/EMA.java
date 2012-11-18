package strategies;

import java.util.List;

import finance.Action;

public class EMA extends StrategyMaster {
	static double slowPastEma;
	static double fastPastEma;
	static double slowEmaValue;
	static double fastEmaValue;
	static double currentSlow;
	static double currentFast;
	static double previousSlow;
	static double previousFast;
	final static double SLOW_ALPHA = (2.0 / 21.0);
	final static double FAST_ALPHA = (1.0 / 3.0);

	public static double getSlowRunningAverage(List<Double> list) {
		double latestPrice = list.get(list.size() - 1);
		if (slowPastEma == 0.0) {
			slowPastEma = latestPrice;
			return slowPastEma;
		}
		slowEmaValue = slowPastEma + (SLOW_ALPHA * (latestPrice - slowPastEma));

		slowPastEma = slowEmaValue;
		return updateSlowValue(round(slowEmaValue));
	}

	public static double getFastRunningAverage(List<Double> list) {
		double latestPrice = list.get(list.size() - 1);
		if (fastPastEma == 0.0) {
			fastPastEma = latestPrice;
			return fastPastEma;
		}
		fastEmaValue = fastPastEma + (FAST_ALPHA * (latestPrice - fastPastEma));

		fastPastEma = fastEmaValue;
		return updateFastValue(round(fastEmaValue));
	}

	private static double updateSlowValue(double newValue) {
		previousSlow = currentSlow;
		currentSlow = newValue;
		//System.out.print("currentSLOW: "+currentFast+" ");
		//System.out.println("pastSLOW: "+previousFast+"");
		return currentSlow;
	}

	private static double updateFastValue(double newValue) {
		previousFast = currentFast;
		currentFast = newValue;
		//System.out.print("currentFAST: "+currentFast+" ");
		//System.out.println("pastFAST: "+previousFast+"");
		//System.out.println();
		return currentFast;
	}

	public static Action update(List<Double> lastPrices) {
		getSlowRunningAverage(lastPrices);
		getFastRunningAverage(lastPrices);
		return getAction();
	}

	/**
	 * Returns the action induced by the algorithm computation.
	 * @return
	 */
	public static Action getAction() {

		if (currentFast > currentSlow && previousFast <= previousSlow) {
			return Action.BUY;
		} else if (currentFast < currentSlow && previousFast >= previousSlow) {
			return Action.SELL;
		}
		return Action.DO_NOTHING;
	}
}
