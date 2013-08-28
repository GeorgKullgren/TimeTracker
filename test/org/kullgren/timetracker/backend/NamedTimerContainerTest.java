package org.kullgren.timetracker.backend;

import static org.junit.Assert.*;

import java.util.Calendar;

import mockit.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@UsingMocksAndStubs({SimpleTimerMock.class})
public class NamedTimerContainerTest {
	NamedTimerContainer func;

	@Before
	public void setUp() throws Exception {
		new SimpleTimerMock();
		func = new NamedTimerContainer();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_create_named_timer_returns_current_time() {
		assertEquals(true, func.createTimer("FirstTimer"));
	}

	@Test
	public void test_start_named_timer() {
		func.createTimer("FirstTimer");
		assertNotEquals(null, func.startTimer("FirstTimer"));
	}
	
	@Test
	public void test_start_not_existing_timer() {
		assertEquals(null, func.startTimer("FirstTimer"));
	}

	@Test
	public void test_create_two_named_timers() {
		assertEquals(true, func.createTimer("FirstTimer"));
		assertEquals(true, func.createTimer("SecondTimer"));
	}
	
	@Test
	public void test_create_same_timer_twice_expect_second_returns_null() {
		assertEquals(true, func.createTimer("FirstTimer"));
		assertEquals(false, func.createTimer("FirstTimer"));		
	}
	
	@Test
	public void test_pause_named_timer() {		
		func.createTimer("FirstTimer");
		func.startTimer("FirstTimer");
		assertEquals(55, func.pauseTimer("FirstTimer"));
	}
	
	@Test
	public void test_pause_not_existing_timer() {
		assertEquals(0, func.pauseTimer("FirstTimer"));
	}
}
