package org.kullgren.timetracker.backend;

public class SimpleTimerMockSettings {
	int pauseReturnValue;
	int stopReturnValue;

	public void setValueForPause(int returnValue) 
	{
		pauseReturnValue = returnValue;
	}
	
	public int getValueForPause()
	{
		return pauseReturnValue;
	}
	
	public void setValueForStop(int returnValue)
	{
		stopReturnValue = returnValue;
	}
	
	public int getValueForStop()
	{
		return stopReturnValue;
	}
}
