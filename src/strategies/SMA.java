package strategies;

import java.util.List;

public class SMA extends StrategyManager {
	static double slowPastSma;
	static double fastPastSma;
	static double slowSmaValue;
	static double fastSmaValue;
	static double lastFastValue;
	static double lastSlowValue;

	public static double getSlowRunningAverage(List<Double> list) {
		if (list.size()<=20){
			slowSmaValue= getAverage(list);
			slowPastSma =slowSmaValue;
			lastSlowValue = list.get(list.size()-1);
			return slowSmaValue;
		}
		slowSmaValue = (slowPastSma - (lastSlowValue/20.0) + (list.get(0))/20.0);
		slowPastSma = round(slowSmaValue);
		lastSlowValue = round(list.get(list.size()-1));
		return round(slowSmaValue);
	}

	public static double getFastRunningAverage(List<Double> list) {
		if (list.size()<=5){
			fastSmaValue= getAverage(list);
			fastPastSma = fastSmaValue;
			lastFastValue = list.get(list.size()-1);
			return round(fastPastSma);
		}
		slowSmaValue = (fastPastSma - round((lastFastValue/5.0)) + round((list.get(0))/5.0));
		fastPastSma = fastSmaValue;
		lastFastValue = list.get(list.size()-1);
		return round(fastSmaValue);
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
