package com.miracle.mft.operation.utils;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
public class MqmftMonitorStatusRowMapperTest {
@Mock
ResultSet rs;
@InjectMocks
MqmftMonitorStatusRowMapper mqmftMonitorStatusRowMapper;
	@Test
	public void test() throws SQLException {
		//fail("Not yet implemented");
		int rowNum =1;
		PowerMockito.when(rs.getString("MonitorNames")).thenReturn("names");
		assertEquals("names", mqmftMonitorStatusRowMapper.mapRow(rs,rowNum).getMonitorNames());
	}

}
