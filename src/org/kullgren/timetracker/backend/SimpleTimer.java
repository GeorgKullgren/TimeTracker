package org.kullgren.timetracker.backend;

import java.util.Calendar;

public class SimpleTimer 
{
	Calendar startTime = null;
	int elapsedTime = 0;
	
	public Calendar startTimer() 
	{
		if (startTime == null) 
		{
			startTime = Calendar.getInstance();
		}
		return startTime;
	}

	public int stopTimer() 
	{
		int totalTime = 0;
		if (startTime != null) 
		{
			totalTime = pauseTimer();
			elapsedTime = 0;
		}
		return totalTime;
	}

	public int pauseTimer() {
		if (startTime != null) 
		{
			Calendar pauseTime = Calendar.getInstance();
			elapsedTime += pauseTime.compareTo(startTime);
			startTime = null;
			return elapsedTime;
		}
		else 
		{
			return 0;
		}
	}
}
