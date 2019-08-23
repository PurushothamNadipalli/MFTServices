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

public class QueueManagerRowMapperTest {


@Mock
ResultSet rs;
@InjectMocks
QueueManagerRowMapper  queueManagerRowMapper;

	@Test
	public void test() throws SQLException {
		PowerMockito.when(rs.getString("HOST_IP")).thenReturn("ip");
		PowerMockito.when(rs.getString("HOST_NAME")).thenReturn("name");
		PowerMockito.when(rs.getString("IS_ACTIVE")).thenReturn("yes");
		PowerMockito.when(rs.getString("IS_AGENT")).thenReturn("no");
		PowerMockito.when(rs.getString("IS_CMND")).thenReturn("cmd");
		PowerMockito.when(rs.getString("IS_COORD")).thenReturn("cord");
		PowerMockito.when(rs.getString("QM_CHANNEL")).thenReturn("channel");
		PowerMockito.when(rs.getString("QM_NAME")).thenReturn("name");
		PowerMockito.when(rs.getString("QM_USERID")).thenReturn("id");
		
		PowerMockito.when(rs.getInt("HOST_ID")).thenReturn(1);
		PowerMockito.when(rs.getInt("QMID")).thenReturn(2);
		PowerMockito.when(rs.getInt("QM_PORT")).thenReturn(5678);
		
		assertEquals("id", queueManagerRowMapper.mapRow(rs,1).getQmUserid());
	}

}
