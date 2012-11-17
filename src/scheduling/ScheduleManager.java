package scheduling;

import server.ConnectionManager;

public class ScheduleManager extends ConnectionManager {

	private int ID;
	private Timer time;
	private boolean working;

	public ScheduleManager(int ID) {
		this.ID = ID;
		this.time = new Timer();
		this.working = true;
	}

	public boolean isWorking() {

		double t = Timer.getTime();

		switch (ID) {
		case 1:
			if ((t > 7200 && t < 9000) || t >= 16200)
				working = false;
			else
				working = true;
		case 2:
			if ((t > 23400 && t < 25200) || (t < 16200 || t >= 32400))
				working = false;
			else
				working = true;
		case 3:
			if (t > 1800)
				working = false;
			else
				working = true;
		case 4:
			if ((t > 9000 && t < 10800) || (t >= 18000 || t < 3600))
				working = false;
			else
				working = true;
		case 5:
			if ((t > 25200 && t < 27000) || (t < 18000 || t >= 32400))
				working = false;
			else
				working = true;
		case 6:
			if ((t > 7200 && t < 10800)) {
				working = true;
			} else
				working = false;
		case 7:
			if ((t > 23400 && t < 27000)) {
				working = true;
			} else
				working = false;
		}

		return working;
	}
}
