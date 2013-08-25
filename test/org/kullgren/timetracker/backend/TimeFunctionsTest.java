package org.kullgren.timetracker.backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TimeFunctionsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewFunction() {
		TimeFunctions func = new TimeFunctions();
		assertEquals(1, func.newFunction());
	}

}
