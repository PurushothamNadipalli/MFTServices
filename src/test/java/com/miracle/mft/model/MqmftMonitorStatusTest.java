package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MqmftMonitorStatusTest {

	@Test
	public void testGetMonitorNames() {
		MqmftMonitorStatus status = new MqmftMonitorStatus();
		status.setMonitorNames("Monitor");
		assertEquals("Monitor", status.getMonitorNames());
		status.setHostId(12);
		assertEquals(12, status.getHostId());
		assertNotNull(status.toString());
	}

}
