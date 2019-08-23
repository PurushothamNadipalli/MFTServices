package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransferLogTest {

	@Test
	public void test() {
		TransferLog log = new TransferLog();
		log.setCompleteId(234123);
		assertEquals(234123, log.getCompleteId());
		log.setDestinationFilename("/usr");
		assertEquals("/usr", log.getDestinationFilename());
		log.setDestinationFileSize(23456);
		assertEquals(23456, log.getDestinationFileSize());
		log.setEndTime("12:34");
		assertEquals("12:34", log.getEndTime());
		log.setFileResult(23456);
		assertEquals(23456, log.getFileResult());
		log.setFileResultMessage("message");
		assertEquals("message", log.getFileResultMessage());
		log.setJobName("job");
		assertEquals("job", log.getJobName());
		log.setNumberOfFiles(345);
		assertEquals(345, log.getNumberOfFiles());
		log.setOverAllResultText("True");
		assertEquals("True", log.getOverAllResultText());
		log.setRelatedTransferId("2345");
		assertEquals("2345", log.getRelatedTransferId());
		log.setResultcode(1234);
		assertEquals(1234, log.getResultcode());
		log.setResultText("Dummt");
		assertEquals("Dummt", log.getResultText());
		log.setScheduleId(23456);
		assertEquals(23456, log.getScheduleId());
		log.setSourceFilename("/des");
		assertEquals("/des", log.getSourceFilename());
		log.setSourceFileSize(234567);
		assertEquals(234567, log.getSourceFileSize());
		log.setSourceSystem("system");
		assertEquals("system", log.getSourceSystem());
		log.setStartId(2345678);
		assertEquals(2345678, log.getStartId());
		log.setStartTime("23:45");
		assertEquals("23:45", log.getStartTime());
		log.setStatus("Running");
		assertEquals("Running", log.getStatus());
		log.setTargetSystem("/dest");
		assertEquals("/dest", log.getTargetSystem());
		log.setTransferId("key");
		assertEquals("key", log.getTransferId());
		assertNotNull(log.toString());
	}

}
