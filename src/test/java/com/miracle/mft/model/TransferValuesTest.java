package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransferValuesTest {

	@Test
	public void test() {
		TransferValues val = new TransferValues();
		val.setDestinationFilename("/dest");
		assertEquals("/dest",val.getDestinationFilename());
		val.setDestinationMessageQueueName("/dest/mq");
		assertEquals("/dest/mq",val.getDestinationMessageQueueName());
		val.setKey("2345");
		assertEquals("2345",val.getKey());
		val.setSourceFilename("review.xml");
		assertEquals("review.xml",val.getSourceFilename());
		val.setValue("34");
		assertEquals("34",val.getValue());
		assertNotNull(val.toString());
	}

}
