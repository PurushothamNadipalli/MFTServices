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

import com.miracle.mft.operation.utils.TransferValueRowMapper;
@RunWith(PowerMockRunner.class)
public class TransferValueOperationTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	TransferValueRowMapper transferValueRowMapper;
	@InjectMocks
	TransferValueOperation transferValueOperation;
	@Test
	public void testgetQueueManagers() {
		PowerMockito.when(jdbcTemplate.query(
				"select M.key as KEYNAME,M.value as KEYVALUES,T.source_filename as SFileName,T.Destination_filename as DFileName,T.destination_message_queue_name as DMQName from FTELOG.metadata M inner join FTELOG.Transfer TS on TS.transfer_id='id' inner join FTELOG.Transfer_item T on T.transfer_id=TS.transfer_id where M.transfer_event_id=TS.complete_id with ur",
				transferValueRowMapper)).thenReturn(null);
		assertEquals(200, transferValueOperation.getData("id").getStatusCodeValue());

	}

	@Test
	public void testgetQueueManagersException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select M.key as KEYNAME,M.value as KEYVALUES,T.source_filename as SFileName,T.Destination_filename as DFileName,T.destination_message_queue_name as DMQName from FTELOG.metadata M inner join FTELOG.Transfer TS on TS.transfer_id='id' inner join FTELOG.Transfer_item T on T.transfer_id=TS.transfer_id where M.transfer_event_id=TS.complete_id with ur",
				transferValueRowMapper);
		assertEquals(400, transferValueOperation.getData("id").getStatusCodeValue());

	}

}
