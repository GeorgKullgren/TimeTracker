package org.kullgren.timetracker.backend;

import java.util.Calendar;

public class TimeFunctions {
	Calendar startTime;
	
	public boolean startTimer() {
		startTime = Calendar.getInstance();
		return true;
	}

	public int stopTimer() {
		Calendar endTime = Calendar.getInstance();
		int elapsedTime = endTime.compareTo(startTime);
		return elapsedTime;
	}
}
