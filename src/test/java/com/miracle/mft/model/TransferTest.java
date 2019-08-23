package com.miracle.mft.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransferTest {

	@Test
	public void test() {
		Transfer transfer = new Transfer();
		transfer.setTransferId("Dev");
		assertEquals("Dev",transfer.getTransferId());
		assertNotNull(transfer.toString());
	}

}
