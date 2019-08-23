package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MqmftUserExitDetailTest {

	@Test
	public void test() {
		MqmftUserExitDetail user = new MqmftUserExitDetail();
		user.setExitId(1234123456);
		assertEquals(1234123456, user.getExitId());
		user.setDeleted("delete");
		assertEquals("delete", user.getDeleted());
		user.setId(1234567889);
		assertEquals(1234567889, user.getId());
		user.setExitParams("params");
		assertEquals("params", user.getExitParams());
		user.setUserExitValue("2345");
		assertEquals("2345", user.getUserExitValue());
		assertNotNull(user.toString());

	}

}
