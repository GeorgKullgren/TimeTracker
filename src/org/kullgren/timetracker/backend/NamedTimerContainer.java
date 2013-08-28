package org.kullgren.timetracker.backend;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class NamedTimerContainer {
	private Map<String, SimpleTimer> bagOfTimers;
	
	public NamedTimerContainer() {
		bagOfTimers = new HashMap<String, SimpleTimer>();
	}
	
	public boolean createTimer(String timerName) {
		if (bagOfTimers.get(timerName) == null) {
			bagOfTimers.put(timerName, new SimpleTimer());
			return true;
		}
		else
		{
			return false;
		}
	}

	public Calendar startTimer(String timerName) {
		SimpleTimer timer = bagOfTimers.get(timerName);
		if (timer != null) {
			return timer.startTimer();
		}
		else
			return null;
	}

	public int pauseTimer(String timerName) {
		SimpleTimer timer = bagOfTimers.get(timerName);
		if (timer != null) {
			return timer.pauseTimer();
		}
		else {
			return 0;
		}
	}

}
