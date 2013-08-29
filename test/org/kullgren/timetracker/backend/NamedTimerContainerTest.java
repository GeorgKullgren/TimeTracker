package org.kullgren.timetracker.backend;

import static org.junit.Assert.*;

import java.util.Calendar;

import mockit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@UsingMocksAndStubs({SimpleTimerMock.class})
public class NamedTimerContainerTest 
{
	NamedTimerContainer func;
	SimpleTimerMockSettings mockSettings;
	
	@Before
	public void setUp() throws Exception 
	{
		mockSettings = new SimpleTimerMockSettings();
		SimpleTimerMock mock = new SimpleTimerMock();
		mock.initializeSetter(mockSettings);
		func = new NamedTimerContainer();
	}

	@After
	public void tearDown() throws Exception 
	{
	}

	@Test
	public void test_create_named_timer_returns_current_time() 
	{
		assertEquals(true, func.createTimer("FirstTimer"));
	}

	@Test
	public void test_start_named_timer() 
	{
		func.createTimer("FirstTimer");
		assertNotEquals(null, func.startTimer("FirstTimer"));
	}
	
	@Test
	public void test_start_not_existing_timer() 
	{
		assertEquals(null, func.startTimer("FirstTimer"));
	}

	@Test
	public void test_create_two_named_timers() 
	{
		assertEquals(true, func.createTimer("FirstTimer"));
		assertEquals(true, func.createTimer("SecondTimer"));
	}
	
	@Test
	public void test_create_same_timer_twice_expect_second_returns_null() 
	{
		assertEquals(true, func.createTimer("FirstTimer"));
		assertEquals(false, func.createTimer("FirstTimer"));		
	}
	
	@Test
	public void test_pause_named_timer()
	{
		mockSettings.setValueForPause(17);
		func.createTimer("FirstTimer");
		func.startTimer("FirstTimer");
		assertEquals(17, func.pauseTimer("FirstTimer"));
	}
	
	@Test
	public void test_pause_not_existing_timer() 
	{
		assertEquals(0, func.pauseTimer("FirstTimer"));
	}
	
	@Test
	public void test_stop_running_timer_returns_19() 
	{
		mockSettings.setValueForStop(19);
		func.createTimer("NewTimer");
		assertEquals(19, func.stopTimer("NewTimer"));
	}
	
	@Test
	public void test_deleting_timer_returns_true() 
	{
		func.createTimer("NewTimer");
		assertEquals(true, func.deleteTimer("NewTimer"));
	}
	
	@Test
	public void test_deleting_non_existing_timer_returns_false()
	{
		assertEquals(false, func.deleteTimer("NewTimer"));
	}
	
	@Test
	public void test_deleteing_same_timer_twice_returns_false()
	{
		func.createTimer("NewTimer");
		func.deleteTimer("NewTimer");
		assertEquals(false, func.deleteTimer("NewTimer"));
	}
}
