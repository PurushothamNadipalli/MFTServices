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

public class UserExitDetailsRowMapperTest {

@Mock
ResultSet rs;
@InjectMocks
UserExitDetailsRowMapper UserExitDetailsRowMapper;
	@Test
	public void test() throws SQLException {
		
		PowerMockito.when(rs.getString("EXIT_PARAMS")).thenReturn("params");
		PowerMockito.when(rs.getString("userexittype")).thenReturn("exittype");
		PowerMockito.when(rs.getString("userexitdetail")).thenReturn("exitdetail");
		
		assertEquals("exitdetail", UserExitDetailsRowMapper.mapRow(rs,1).getUserExitValue());
	}

}
