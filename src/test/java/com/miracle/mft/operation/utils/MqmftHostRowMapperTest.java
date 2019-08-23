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

import com.miracle.mft.model.MqmftHost;
@RunWith(PowerMockRunner.class)
public class MqmftHostRowMapperTest {
@InjectMocks
MqmftHostRowMapper mqmftHostRowMapper;
@Mock
ResultSet rs;
	@Test
	public void test() throws SQLException {
		//fail("Not yet implemented");
		int rowNum =1;
		PowerMockito.when(rs.getInt("AGENT_PORT")).thenReturn(1);
		PowerMockito.when(rs.getInt("COORD_PORT")).thenReturn(2);
		PowerMockito.when(rs.getInt("HOST_ID")).thenReturn(3);
	
		PowerMockito.when(rs.getString("ACTIVE")).thenReturn("state");
		PowerMockito.when(rs.getString("AGENT_QMGR")).thenReturn("qmgr");
		PowerMockito.when(rs.getString("COORD_QMGR")).thenReturn("cqmgr");
		PowerMockito.when(rs.getString("DEFAULT_CHANNEL")).thenReturn("chaneel");
		PowerMockito.when(rs.getString("DELETED")).thenReturn("del");
		PowerMockito.when(rs.getString("HOST_IP")).thenReturn("ip");
		PowerMockito.when(rs.getString("HOST_NAME")).thenReturn("name");
		PowerMockito.when(rs.getString("USER_ID")).thenReturn("id");
		
		assertEquals("id", mqmftHostRowMapper.mapRow(rs, rowNum).getUserId());
	}

}
