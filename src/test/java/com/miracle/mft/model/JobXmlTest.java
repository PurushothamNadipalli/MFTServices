package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class JobXmlTest {

	@Test
	public void test() {
		JobXml jobXml = new JobXml();
		jobXml.setJobXML("<jobXML></jobXML>");
		assertEquals("<jobXML></jobXML>", jobXml.getJobXML());
		assertNotNull(jobXml.toString());
	}

}
