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

public class MqmftUserExitRowMapperTest {
	
		@Mock
		ResultSet rs;
		@InjectMocks
		MqmftUserExitRowMapper mqmftUserExitRowMapper;
	@Test
	public void test() throws SQLException {
		
		PowerMockito.when(rs.getLong("ID")).thenReturn(32324l);
		PowerMockito.when(rs.getString("USER_EXIT_TYPE")).thenReturn("exitvalues");
		assertEquals("exitvalues", mqmftUserExitRowMapper.mapRow(rs,1).getUserExitType());
	}

}
