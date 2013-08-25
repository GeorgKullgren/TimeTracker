package org.kullgren.timetracker.backend;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeFunctionsTest {
	TimeFunctions func;
	
	@Before
	public void setUp() throws Exception {
		func = new TimeFunctions();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_start_new_timer_returns_true() {
		assertEquals(true, func.startTimer());
	}
	
	@Test
	public void test_stop_running_timer_returns_55_seconds() {
		func.startTimer();
		assertEquals(55, func.stopTimer());
	}
	
	@Test
	public void test_stop_running_timer_returns_5040_seconds() {
		func.startTimer();
		assertEquals(5040, func.stopTimer());
	}
}
