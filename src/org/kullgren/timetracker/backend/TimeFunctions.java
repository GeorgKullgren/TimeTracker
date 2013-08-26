package org.kullgren.timetracker.backend;

import java.util.Calendar;

public class TimeFunctions {
	Calendar startTime;
	
	public Calendar startTimer() {
		startTime = Calendar.getInstance();
		return startTime;
	}

	public int stopTimer() {
		Calendar endTime = Calendar.getInstance();
		int elapsedTime = endTime.compareTo(startTime);
		return elapsedTime;
	}

	public int pauseTimer() {
		Calendar pauseTime = Calendar.getInstance();
		int elapsedTime = pauseTime.compareTo(startTime);
		return elapsedTime;
	}
}
