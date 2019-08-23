package com.miracle.mft.operations;

import static org.junit.Assert.*;

import org.junit.Test;

public class MqmftMonitorsTest {

	@Test
	public void test() {
		MqmftMonitors monitors=new MqmftMonitors();
		monitors.setAgent("agent");
		monitors.setMonitor_ID("Mid");
		monitors.setMonitorName("mname");
		monitors.setMxml("mxml");
		monitors.setQMGR("Qmanager");
		monitors.setStatus("mstatus");
		assertEquals("agent",monitors.getAgent());
		assertEquals("Mid",monitors.getMonitor_ID());
		assertEquals("mname",monitors.getMonitorName());
		assertEquals("mxml",monitors.getMxml());
		assertEquals("Qmanager",monitors.getQMGR());
		assertEquals("mstatus",monitors.getStatus());
		assertNotNull(monitors.toString());
	}

}
