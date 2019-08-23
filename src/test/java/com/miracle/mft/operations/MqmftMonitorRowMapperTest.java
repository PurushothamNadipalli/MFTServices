package com.miracle.mft.operations;

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
public class MqmftMonitorRowMapperTest {
	@Mock
	ResultSet rs;
	@InjectMocks
	MqmftMonitorRowMapper mqmftMonitorRowMapper;

	@Test
	public void testRowMapper() throws SQLException {
		PowerMockito.when(rs.getString("Monitor_ID")).thenReturn("id");
		PowerMockito.when(rs.getString("MonitorName")).thenReturn("name");
		PowerMockito.when(rs.getString("QMGR")).thenReturn("queueManager");
		PowerMockito.when(rs.getString("Agent")).thenReturn("agent");
		PowerMockito.when(rs.getString("mxml")).thenReturn("MonitorXml");
		PowerMockito.when(rs.getString("Status")).thenReturn("true");

		assertEquals("id", mqmftMonitorRowMapper.mapRow(rs, 1).getMonitor_ID());
	}

}
