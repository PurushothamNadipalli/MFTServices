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

	public class OriginalXMLRequestRowMapperTest {

	@Mock
	ResultSet rs;
	@InjectMocks
	OriginalXMLRequestRowMapper originalXMLRequestRowMapper;

	@Test
	public void test() throws SQLException {
		PowerMockito.when(rs.getString("MO_XML")).thenReturn("xml");
		assertEquals("xml", originalXMLRequestRowMapper.mapRow(rs,1).getMo_xml());
	}

}
