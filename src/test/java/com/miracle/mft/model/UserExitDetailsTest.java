package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserExitDetailsTest {

	@Test
	public void test() {
		UserExitDetails exit = new UserExitDetails();
		exit.setExitParams("/dev");
		assertEquals("/dev",exit.getExitParams());
		exit.setUserExitType("review");
		assertEquals("review",exit.getUserExitType());
		exit.setUserExitValue("2");
		assertEquals("2",exit.getUserExitValue());
		assertNotNull(exit.toString());
	}

}
