package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class MqmftUserExitTest {

	@Test
	public void test() {
		MqmftUserExit exit = new MqmftUserExit();
		exit.setId(1);
		assertEquals(1,exit.getId());
		exit.setUserExitType("Exit");
		assertEquals("Exit",exit.getUserExitType());
		assertNotNull(exit.toString());
	}

}
