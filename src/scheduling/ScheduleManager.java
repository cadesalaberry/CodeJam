package scheduling;

import server.ConnectionManager;
import strategies.Strategy;

public class ScheduleManager extends ConnectionManager {

	private int ID;
	private boolean working;

	public ScheduleManager(Strategy one, Strategy two, int ID) {
		super(one, two);
		this.ID = ID;
		this.working = true;
	}

	public boolean isWorkingAt(int time) {

		double t = Timer.getTime();

		switch (ID) {
		case 1:
			// Working hours: 0-7200 && 9000-16200
			working = 0 < t && t < 7200 || 9000 < t && t < 16200;
			break;
		case 2:
			// Working Hours: 16200-23400 && 25200-32400
			working = 16200 < t && t < 23400 || 25200 < t && t < 32400;
			break;
		case 3:
			// Working Hours: 0-1800
			working = !(t > 1800);
			break;
		case 4:
			// Working Hours: 3600-9000 && 10800-18000
			working = 3600 < t && t < 9000 && 10800 < t && t < 18000;
			break;
		case 5:
			// Working Hours: 18000-25200 && 27000-32400
			working = 18000 < t && t < 25200 || 27000 < t && t < 32400;
			break;
		case 6:
			// Working Hours: 7200-10800 with Strategy switch @9000
			working = 7200 < t && t < 10800;

			if (t == 9000) {
				this.changeStrategy(Strategy.SMA, Strategy.EMA);
				this.changeStrategy(Strategy.LWMA, Strategy.TMA);
			}
			break;
		case 7:
			// Working Hours: 27000-23400 with Strategy switch @25200
			working = 23400 < t && t < 27000;

			if (t == 25200) {
				this.changeStrategy(Strategy.SMA, Strategy.EMA);
				this.changeStrategy(Strategy.LWMA, Strategy.TMA);
			}
			break;
		case 0: {
			working = true;
		}
		}

		return working;
	}

	/**
	 * Returns if the manager is still working at that point or not.
	 * 
	 * @return
	 */
	public boolean isWorking() {

		return isWorkingAt(Timer.getTime());
	}
}
