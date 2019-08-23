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
public class MqmftUserExitDetailRowMapperTest {
	@Mock
	ResultSet rs;
	@InjectMocks
	MqmftUserExitDetailRowMapper mqmftUserExitDetailRowMapper;
	@Test
	public void test() throws SQLException {
		
		int rowNum =1;
		long l = 01234l;
		long l2 = 212l;
		PowerMockito.when(rs.getLong("EXIT_ID")).thenReturn(l);
		PowerMockito.when(rs.getString("EXIT_PARAMS")).thenReturn("exitparams");
		PowerMockito.when(rs.getLong("EXIT_ID")).thenReturn(l2);
		PowerMockito.when(rs.getString("USER_EXIT_VALUE")).thenReturn("exitvalues");
		
		assertEquals("exitparams", mqmftUserExitDetailRowMapper.mapRow(rs,rowNum).getExitParams());
	}

}

