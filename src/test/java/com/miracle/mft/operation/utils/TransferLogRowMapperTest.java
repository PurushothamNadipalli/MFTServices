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

public class TransferLogRowMapperTest {

@Mock
ResultSet rs;
@InjectMocks
TransferLogRowMapper TransferLogRowMapper;	
@Test
	public void test() throws SQLException {
	
	PowerMockito.when(rs.getString("JOBNAME")).thenReturn("job");
	PowerMockito.when(rs.getString("TRANSFERID")).thenReturn("transferid");
	PowerMockito.when(rs.getString("SOURCESYSTEM")).thenReturn("ssystem");
	PowerMockito.when(rs.getString("TARGETSYSTEM")).thenReturn("tsystem");
	PowerMockito.when(rs.getString("OVERALLRESULTTEXT")).thenReturn("restext");
	PowerMockito.when(rs.getString("STARTTIME")).thenReturn("times");
	PowerMockito.when(rs.getString("ENDTIME")).thenReturn("timee");
	PowerMockito.when(rs.getString("SOURCEFILE")).thenReturn("sfile");
	PowerMockito.when(rs.getString("DESTINATIONFILE")).thenReturn("dfile");
	PowerMockito.when(rs.getString("FILERESULTMESSAGE")).thenReturn("msg");
	PowerMockito.when(rs.getString("STATUS")).thenReturn("status");
	
	PowerMockito.when(rs.getInt("OVERALLRESULT")).thenReturn(1);
	PowerMockito.when(rs.getInt("SOURCEFILESIZE")).thenReturn(2);
	PowerMockito.when(rs.getInt("DESTINATIONFILESIZE")).thenReturn(5678);
	PowerMockito.when(rs.getInt("FILERESULT")).thenReturn(1);
	
	assertEquals(2, TransferLogRowMapper.mapRow(rs,1).getSourceFileSize());
		
	}

}
