package org.kullgren.timetracker.backend;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import mockit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sun.util.resources.CalendarData;

public class SimpleTimeFunctionsTest {
	SimpleTimer func;

	@Before
	public void setUp() throws Exception {
		func = new SimpleTimer();
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
	public void test_stop_idle_timer_returns_0() {
		assertEquals(0, func.stopTimer());
	}
	
	@Test
	public void test_stop_stopped_timer_returns_0() {
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
		assertEquals(0, func.stopTimer());
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
	
	@Test
	public void test_pause_restart_stop_timer_returns_total() {
		final Calendar startTime = Calendar.getInstance();
		final Calendar pauseTime = Calendar.getInstance();
		final Calendar restartTime = Calendar.getInstance();
		final Calendar stopTime = Calendar.getInstance();
		
		new Expectations() {
			Calendar mockCalendar;
			{
				Calendar.getInstance(); result = startTime;
				Calendar.getInstance(); result = pauseTime;
				mockCalendar.compareTo(startTime); result = 17;
				Calendar.getInstance(); result = restartTime;
				Calendar.getInstance(); result = stopTime;
				mockCalendar.compareTo(restartTime); result = 23;
			}
		};
		
		func.startTimer();
		assertEquals(17, func.pauseTimer());
		func.startTimer();
		assertEquals(40, func.stopTimer());
	}

	@Test
	public void test_stop_timer_start_timer_resets_counted_time() {
		final Calendar firstStartTime = Calendar.getInstance();
		final Calendar secondStartTime = Calendar.getInstance();
		final Calendar stopTime = Calendar.getInstance();
		
		new Expectations() {
			Calendar mockCalendar;
			{
				Calendar.getInstance(); result = firstStartTime;
				Calendar.getInstance(); result = stopTime;
				mockCalendar.compareTo(firstStartTime); result = 17;
				Calendar.getInstance(); result = secondStartTime;
				Calendar.getInstance(); result = stopTime;
				mockCalendar.compareTo(secondStartTime); result = 23;
			}
		};
		
		func.startTimer();
		assertEquals(17, func.stopTimer());
		func.startTimer();
		assertEquals(23, func.stopTimer());	
	}
	
	@Test
	public void test_pause_not_started_timer_returns_0() {
		assertEquals(0, func.pauseTimer());
	}

}




