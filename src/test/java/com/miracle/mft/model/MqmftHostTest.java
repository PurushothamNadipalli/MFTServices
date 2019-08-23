package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MqmftHostTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		assertEquals(1, host.getHostId());
		host.setActive("Active");
		assertEquals("Active", host.getActive());
		host.setAgentPort(1);
		assertEquals(1, host.getAgentPort());
		host.setAgentQmgr("EB110005");
		assertEquals("EB110005", host.getAgentQmgr());
		host.setCoordPort(2);
		assertEquals(2, host.getCoordPort());
		host.setCoordQmgr("COORDINATION Q MANAGER");
		assertEquals("COORDINATION Q MANAGER", host.getCoordQmgr());
		host.setDefaultChannel("Channel");
		assertEquals("Channel", host.getDefaultChannel());
		host.setDeleted("delete");
		assertEquals("delete", host.getDeleted());
		host.setHostIp("IP");
		assertEquals("IP", host.getHostIp());
		host.setHostName("hostname");
		assertEquals("hostname", host.getHostName());
		host.setUserId("userId");
		assertEquals("userId", host.getUserId());
		assertNotNull(host.toString());

	}

}
