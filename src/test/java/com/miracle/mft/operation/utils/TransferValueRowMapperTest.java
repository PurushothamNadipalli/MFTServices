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

public class TransferValueRowMapperTest {

@Mock
ResultSet rs;
@InjectMocks
TransferValueRowMapper TransferValueRowMapper;	

	@Test
	public void test() throws SQLException {
		PowerMockito.when(rs.getString("KEYNAME")).thenReturn("key");
		PowerMockito.when(rs.getString("DFileName")).thenReturn("dfile");
		PowerMockito.when(rs.getString("DMQName")).thenReturn("dmq");
		PowerMockito.when(rs.getString("SFileName")).thenReturn("ssystem");
		PowerMockito.when(rs.getString("KEYVALUES")).thenReturn("values");
		
		assertEquals("values", TransferValueRowMapper.mapRow(rs,1).getValue());
	}

}
