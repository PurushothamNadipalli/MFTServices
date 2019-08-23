package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miracle.mft.operation.utils.TransferRowMapper;

@RunWith(PowerMockRunner.class)
public class TransferOperationTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	TransferRowMapper transferRowMapper;
	@InjectMocks
	TransferOperation transferOperation;

	@Test
	public void testgetData() {
		PowerMockito.when(jdbcTemplate.query(
				"SELECT DISTINCT JOB_NAME FROM FTELOG.TRANSFER order by job_name with ur;",
				transferRowMapper)).thenReturn(null);
		assertEquals(200, transferOperation.getData().getStatusCodeValue());

	}

	@Test
	public void testgetDataException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"SELECT DISTINCT JOB_NAME FROM FTELOG.TRANSFER order by job_name with ur;",
				transferRowMapper);
		assertEquals(400, transferOperation.getData().getStatusCodeValue());

	}
}
