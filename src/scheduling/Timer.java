package scheduling;

public class Timer {

	static int timer = 1;

	/**
	 * Returns the time.
	 * 
	 * @return currentTime;
	 */
	public static int getTime() {
		return timer;
	}

	/**
	 * Returns the current Time, then increment the Timer by one.
	 * 
	 */
	public static int incrementTime() {
		return timer++;
	}

}
