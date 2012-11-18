package strategies;

import java.util.LinkedList;
import java.util.List;

import finance.Action;

public class TMA extends StrategyMaster {
	static double slowTmaValue;
	static double fastTmaValue;
	static double currentSlow;
	static double currentFast;
	static double previousSlow;
	static double previousFast;
	public static LinkedList<Double> slowSmas = new LinkedList<Double>();
	public static LinkedList<Double> fastSmas = new LinkedList<Double>();
	
	//Computes slow tunning average 
	public static double getSlowRunningAverage(List<Double> list) {
		double temp = 0;
		double returnValue = 0;
		for (int i = 1; i < (list.size() + 1); i++) {

			if (i < 21) {
				temp = SMA.getSlowRunningAverage(list.subList(0, i));
				slowSmas.addLast(temp);

			} else {
				temp = SMA.getSlowRunningAverage(list.subList(i - 20, i));
				slowSmas.removeFirst();
				slowSmas.addLast(temp);
			}
		}

		returnValue = getAverage(slowSmas);
		slowSmas = new LinkedList<Double>();
		return updateSlowValue(returnValue);

	}
	//Compte fast running average
	public static double getFastRunningAverage(List<Double> list) {
		double temp = 0;
		double returnValue = 0;
		for (int i = 1; i < (list.size() + 1); i++) {

			if (i < 6) {
				temp = SMA.getFastRunningAverage(list.subList(0, i));
				fastSmas.addLast(temp);

			} else {
				temp = SMA.getFastRunningAverage(list.subList(i - 5, i));
				fastSmas.removeFirst();
				fastSmas.addLast(temp);
			}
		}

		returnValue = getAverage(fastSmas);
		fastSmas = new LinkedList<Double>();
		return updateFastValue(returnValue);
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
