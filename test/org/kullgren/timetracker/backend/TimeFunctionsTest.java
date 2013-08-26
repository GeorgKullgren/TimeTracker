package org.kullgren.timetracker.backend;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import mockit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sun.util.resources.CalendarData;

public class TimeFunctionsTest {
	TimeFunctions func;
		
	@Before
	public void setUp() throws Exception {
		func = new TimeFunctions();
	}

	@Test
	public void test_start_new_timer_returns_current_time() {
		final Calendar startTime = Calendar.getInstance();
		
		new Expectations(Calendar.class) {
			{
				Calendar.getInstance(); result = startTime;
			}
		};
				
		assertEquals(startTime, func.startTimer());
	}

	@Test
	public void test_trying_to_start_running_timer_returns_original_start_time() {
		final Calendar startTime = Calendar.getInstance();
		
		new Expectations(Calendar.class) {
			{
				Calendar.getInstance(); result = startTime;
			}
		};
		
		Calendar firstStartTime = func.startTimer();
		assertEquals(firstStartTime, func.startTimer());		
	}
	
	@Test
	public void test_stop_running_timer_returns_55() {
		final Calendar startTime = Calendar.getInstance();
		final Calendar endTime = Calendar.getInstance();
		
		new Expectations() {
			Calendar mockCalendar;
			
			{
				Calendar.getInstance(); result = startTime;
				Calendar.getInstance(); result = endTime;
				mockCalendar.compareTo(startTime); result = 55;
			}
		};
		
		func.startTimer();
		assertEquals(55, func.stopTimer());
	}
	
	@Test
	public void test_stop_running_timer_returns_5040() {
		final Calendar startTime = Calendar.getInstance();
		final Calendar endTime = Calendar.getInstance();
		
		new Expectations() {
			Calendar mockCalendar;
			
			{
				Calendar.getInstance(); result = startTime;
				Calendar.getInstance(); result = endTime;
				mockCalendar.compareTo(startTime); result = 5040;
			}
		};
		
		func.startTimer();
		assertEquals(5040, func.stopTimer());
	}
	
	@Test
	public void test_pause_timer_returns_elapsed_time_45() {
		final Calendar startTime = Calendar.getInstance();
		final Calendar pauseTime = Calendar.getInstance();
		
		new Expectations() {
			Calendar mockCalendar;
			
			{
				Calendar.getInstance(); result = startTime;
				Calendar.getInstance(); result = pauseTime;
				mockCalendar.compareTo(startTime); result = 45;
			}
		};
		
		func.startTimer();
		assertEquals(45, func.pauseTimer());		
	}
	
	
}


