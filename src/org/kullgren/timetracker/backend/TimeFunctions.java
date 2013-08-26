package org.kullgren.timetracker.backend;

import java.util.Calendar;

public class TimeFunctions {
	Calendar startTime = null;
	
	public Calendar startTimer() {
		if (startTime == null) {
			startTime = Calendar.getInstance();
		}
		return startTime;
	}

	public int stopTimer() {
		Calendar endTime = Calendar.getInstance();
		int elapsedTime = endTime.compareTo(startTime);
		startTime = null;
		return elapsedTime;
	}

	public int pauseTimer() {
		Calendar pauseTime = Calendar.getInstance();
		int elapsedTime = pauseTime.compareTo(startTime);
		return elapsedTime;
	}
}
