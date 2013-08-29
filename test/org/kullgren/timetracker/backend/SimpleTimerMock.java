package org.kullgren.timetracker.backend;

import java.util.Calendar;

import mockit.*;

public final class SimpleTimerMock extends MockUp<SimpleTimer>{
	private SimpleTimerMockSettings mockSettings;
	
	void initializeSetter(SimpleTimerMockSettings settings) {mockSettings = settings;}
	@Mock public Calendar startTimer() {return Calendar.getInstance();}
	@Mock public int stopTimer() {return mockSettings.getValueForStop();}
	@Mock public int pauseTimer() {return mockSettings.getValueForPause();}

}
