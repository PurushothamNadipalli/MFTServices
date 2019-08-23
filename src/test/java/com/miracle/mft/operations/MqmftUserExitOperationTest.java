package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;
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

import com.miracle.mft.model.MqmftUserExit;
import com.miracle.mft.operation.utils.MqmftUserExitRowMapper;

@RunWith(PowerMockRunner.class)
public class MqmftUserExitOperationTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private MqmftUserExitRowMapper mqmftUserExitRowMapper;
	private List<MqmftUserExit> userExits;
	@InjectMocks
	MqmftUserExitOperation mqmftUserExitOperation;

	@Test
	public void testUpdate() {
		PowerMockito
				.when(jdbcTemplate.update("Update FTELOG.MQMFT_User_Exits set User_Exit_Type='exitType' where ID=1"))
				.thenReturn(1);
		assertEquals(200, mqmftUserExitOperation.update(1, "exitType").getStatusCodeValue());

	}

	@Test
	public void testUpdateException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.update("Update FTELOG.MQMFT_User_Exits set User_Exit_Type='exitType' where ID=1");
		assertEquals(400, mqmftUserExitOperation.update(1, "exitType").getStatusCodeValue());

	}

	@Test
	public void testgetuserExitYpes() {
		PowerMockito.when(jdbcTemplate.query("Select ID,User_Exit_Type from FTELOG.mqmft_user_exits with ur",
				mqmftUserExitRowMapper)).thenReturn(null);
		assertEquals(200, mqmftUserExitOperation.getuserExitYpes().getStatusCodeValue());

	}

	@Test
	public void testgetuserExitYpesException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.query("Select ID,User_Exit_Type from FTELOG.mqmft_user_exits with ur", mqmftUserExitRowMapper);
		assertEquals(400, mqmftUserExitOperation.getuserExitYpes().getStatusCodeValue());

	}

	@Test
	public void testInsert() {
		PowerMockito.doNothing().when(jdbcTemplate)
				.execute("Insert into FTELOG.MQMFT_User_Exits(User_Exit_Type)values('exitType')");
		assertEquals(200, mqmftUserExitOperation.insert("exitType").getStatusCodeValue());

	}

	@Test
	public void testInsertException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.execute("Insert into FTELOG.MQMFT_User_Exits(User_Exit_Type)values('exitType')");
		assertEquals(400, mqmftUserExitOperation.insert("exitType").getStatusCodeValue());

	}
}
