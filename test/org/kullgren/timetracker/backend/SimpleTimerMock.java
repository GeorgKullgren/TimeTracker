package org.kullgren.timetracker.backend;

import java.util.Calendar;

import mockit.*;

public final class SimpleTimerMock extends MockUp<SimpleTimer>{
	@Mock public Calendar startTimer() {return Calendar.getInstance();}
	@Mock public int stopTimer() {return 43;}
	@Mock public int pauseTimer() {return 55;}

}
