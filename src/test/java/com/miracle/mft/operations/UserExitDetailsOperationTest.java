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

import com.miracle.mft.operation.utils.UserExitDetailsRowMapper;

@RunWith(PowerMockRunner.class)
public class UserExitDetailsOperationTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private UserExitDetailsRowMapper userExitDetailsRowMapper;
	@InjectMocks
	UserExitDetailsOperation userExitDetailsOperation;

	@Test
	public void testgetQueueManagers() {
		PowerMockito.when(jdbcTemplate.query(
				"select u.user_exit_type as userexittype,ud.user_Exit_value as userexitdetail, ud.Exit_Params  from FTELOG.MQMFT_USER_EXITS u , FTELOG.MQMFT_USER_EXIT_DETAILS ud where ud.id=u.id and ud.deleted='N' group by u.user_exit_type,ud.user_exit_value,ud.Exit_Params",
				userExitDetailsRowMapper)).thenReturn(null);
		assertEquals(200, userExitDetailsOperation.getValues().getStatusCodeValue());

	}

	@Test
	public void testgetQueueManagersException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select u.user_exit_type as userexittype,ud.user_Exit_value as userexitdetail, ud.Exit_Params  from FTELOG.MQMFT_USER_EXITS u , FTELOG.MQMFT_USER_EXIT_DETAILS ud where ud.id=u.id and ud.deleted='N' group by u.user_exit_type,ud.user_exit_value,ud.Exit_Params",
				userExitDetailsRowMapper);
		assertEquals(400, userExitDetailsOperation.getValues().getStatusCodeValue());

	}
}
