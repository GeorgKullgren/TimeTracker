package org.kullgren.timetracker.backend;

import java.util.Calendar;

public interface TimerInterface {
	public Calendar startTimer();
	public int stopTimer();
	public int pauseTimer();
}
