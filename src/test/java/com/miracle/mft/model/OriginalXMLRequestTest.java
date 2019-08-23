package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class OriginalXMLRequestTest {

	@Test
	public void test() {
		OriginalXMLRequest req = new OriginalXMLRequest();
		req.setMo_xml("XML");
		assertEquals("XML", req.getMo_xml());
		assertNotNull(req.toString());
	}

}
