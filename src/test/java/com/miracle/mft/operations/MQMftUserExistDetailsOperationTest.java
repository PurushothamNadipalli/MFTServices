package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miracle.mft.model.MqmftMonitorStatus;
import com.miracle.mft.model.MqmftUserExitDetail;
import com.miracle.mft.operation.utils.MqmftUserExitDetailRowMapper;

@RunWith(PowerMockRunner.class)
public class MQMftUserExistDetailsOperationTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private MqmftUserExitDetailRowMapper mqmftUserExitDetailRowMapper;
	private List<MqmftUserExitDetail> userDetails;
	@InjectMocks
	MQMftUserExistDetailsOperation mQMftUserExistDetailsOperation;

	@Test
	public void testUpdate() {
		PowerMockito.when(jdbcTemplate.update("Update FTELOG.MQMFT_User_Exit_Details set Deleted='Y' where Exit_id=1"))
				.thenReturn(1);
		assertEquals(200, mQMftUserExistDetailsOperation.update(1).getStatusCodeValue());

	}

	@Test
	public void testUpdateException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.update("Update FTELOG.MQMFT_User_Exit_Details set Deleted='Y' where Exit_id=1");
		assertEquals(400, mQMftUserExistDetailsOperation.update(1).getStatusCodeValue());

	}

	@Test
	public void testUpdateValues() {
		PowerMockito.when(jdbcTemplate.update(
				"Update FTELOG.MQMFT_User_Exit_Details set User_Exit_Value='value',Exit_Params='parems' where Exit_id=1"))
				.thenReturn(1);
		assertEquals(200, mQMftUserExistDetailsOperation.UpdateValues(1, "value", "parems").getStatusCodeValue());

	}

	@Test
	public void testUpdateValuesExeption() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).update(
				"Update FTELOG.MQMFT_User_Exit_Details set User_Exit_Value='value',Exit_Params='parems' where Exit_id=1");
		assertEquals(400, mQMftUserExistDetailsOperation.UpdateValues(1, "value", "parems").getStatusCodeValue());

	}

	@Test
	public void testInsert() {
		PowerMockito.doNothing().when(jdbcTemplate).execute(
				"Insert into FTELOG.MQMFT_User_Exit_Details(ID,User_Exit_value,Exit_Params)values(1,'userExitValues','params')");
		assertEquals(200, mQMftUserExistDetailsOperation.insert(1, "userExitValues", "params").getStatusCodeValue());

	}

	@Test
	public void testInsertException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).execute(
				"Insert into FTELOG.MQMFT_User_Exit_Details(ID,User_Exit_value,Exit_Params)values(1,'userExitValues','params')");
		assertEquals(400, mQMftUserExistDetailsOperation.insert(1, "userExitValues", "params").getStatusCodeValue());

	}

	@Test
	public void testGetValues() {
		PowerMockito.when(jdbcTemplate.query(
				"select Exit_id,ID,user_exit_value,Exit_Params from FTELOG.mqmft_user_exit_details where ID=1 and Deleted='Y' order by ID with ur",
				mqmftUserExitDetailRowMapper)).thenReturn(null);
		assertEquals(200, mQMftUserExistDetailsOperation.getValues(1).getStatusCodeValue());

	}

	@Test
	public void testGetValuesException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select Exit_id,ID,user_exit_value,Exit_Params from FTELOG.mqmft_user_exit_details where ID=1 and Deleted='Y' order by ID with ur",
				mqmftUserExitDetailRowMapper);
		assertEquals(400, mQMftUserExistDetailsOperation.getValues(1).getStatusCodeValue());

	}

}
