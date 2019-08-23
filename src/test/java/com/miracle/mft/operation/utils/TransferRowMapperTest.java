package com.miracle.mft.operation.utils;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)

public class TransferRowMapperTest {

	@Mock
	ResultSet rs;
	@InjectMocks
	TransferRowMapper TransferRowMapper;

	@Test
	public void test() throws SQLException {
		PowerMockito.when(rs.getString("JOB_NAME")).thenReturn("job");
		assertEquals("job", TransferRowMapper.mapRow(rs,1).getTransferId());
	}

}
