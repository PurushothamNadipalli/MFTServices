package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueManagerTest {

	@Test
	public void test() {
		QueueManager mgr = new QueueManager();
		mgr.setHost_ip("234");
		assertEquals("234", mgr.getHost_ip());
		mgr.setHost_name("host");
		assertEquals("host", mgr.getHost_name());
		mgr.setHostId(1);
		assertEquals(1, mgr.getHostId());
		mgr.setIsActive("true");
		assertEquals("true", mgr.getIsActive());
		mgr.setIsAgent("false");
		assertEquals("false", mgr.getIsAgent());
		mgr.setIsCmnd("cmd");
		assertEquals("cmd", mgr.getIsCmnd());
		mgr.setIsCoord("Coord");
		assertEquals("Coord", mgr.getIsCoord());
		mgr.setQmChannel("chaneel");
		assertEquals("chaneel", mgr.getQmChannel());
		mgr.setQmid(12);
		assertEquals(12, mgr.getQmid());
		mgr.setQmName("qmname");
		assertEquals("qmname", mgr.getQmName());
		mgr.setQmPort(12);
		assertEquals(12, mgr.getQmPort());
		mgr.setQmUserid("user");
		assertEquals("user", mgr.getQmUserid());
		assertNotNull(mgr.toString());
	}

}
