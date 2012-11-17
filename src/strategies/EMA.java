package strategies;

import java.util.List;

public class EMA extends StrategyManager {
	static double slowPastEma;
	static double fastPastEma;
	static double slowEmaValue;
	static double fastEmaValue;
	final static double SLOW_ALPHA = (2.0/21.0);
	final static double FAST_ALPHA= (1.0/3.0);

	
	public static double getSlowRunningAverage(double latestPrice) {
		if (slowPastEma == 0.0) {
			slowPastEma = latestPrice;
		return slowPastEma;
		}
		slowEmaValue= slowPastEma + (SLOW_ALPHA*(latestPrice - slowPastEma));
		
		slowPastEma = slowEmaValue;
		return round(slowEmaValue);
	}

	public static double getFastRunningAverage(double latestPrice) {
		if (fastPastEma == 0.0) {
			fastPastEma = latestPrice;
		return fastPastEma;
		}
		fastEmaValue= fastPastEma + (FAST_ALPHA*(latestPrice - fastPastEma));
		
		fastPastEma = fastEmaValue;
		return round(fastEmaValue);
	}

	public static Action getAction(){
		return Action.NOTHING;
	}


	public static Action update(List<Double> lastPrices) {
		// TODO Auto-generated method stub
		return null;
	}
}
