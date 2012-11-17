package strategies;

import finance.Action;

public class EMA extends StrategyManager {
	static double slowPastEma;
	static double fastPastEma;
	static double slowEmaValue;
	static double fastEmaValue;
	final static double slowAlpha = 2/6;
	final static double fastAlpha = 2/21;

	public static double getSlowRunningAverage(double latestPrice) {
		if (slowPastEma == 0.0) {
			slowPastEma = latestPrice;
		}
		slowEmaValue= slowPastEma + (slowAlpha*(latestPrice - slowPastEma));
		slowPastEma = slowEmaValue;
		return slowEmaValue;
	}

	public static double getFastRunningAverage(double latestPrice) {
		if (fastPastEma == 0.0) {
			fastPastEma = latestPrice;
		}
		fastEmaValue= fastPastEma + (fastAlpha*(latestPrice - fastPastEma));
		fastPastEma = fastEmaValue;
		return fastEmaValue;
	}

	public Action getAction(){
		return Action.NOTHING;
	}

}
