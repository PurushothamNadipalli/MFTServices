package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miracle.mft.model.OriginalXMLRequest;
import com.miracle.mft.operation.utils.OriginalXMLRequestRowMapper;

@RunWith(PowerMockRunner.class)
public class OriginalXMLRequestOperationsTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private OriginalXMLRequestRowMapper originalXMLRequestRowMapper;
	@InjectMocks
	OriginalXMLRequestOperations originalXMLRequestOperations;

	@Test
	public void testGetValues() {
		PowerMockito.when(jdbcTemplate.query(
				"select ma.original_xml_request as MO_XML from (select max(id) as id from FTELOG.monitor where id='1')ss inner join FTELOG.monitor_action ma on ma.monitor=ss.id and ma.action='create' and ma.original_xml_request is not null with ur",
				originalXMLRequestRowMapper)).thenReturn(null);
		assertEquals(200, originalXMLRequestOperations.getOriginalXml("1").getStatusCodeValue());

	}

	@Test
	public void testGetValuesException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select ma.original_xml_request as MO_XML from (select max(id) as id from FTELOG.monitor where id='1')ss inner join FTELOG.monitor_action ma on ma.monitor=ss.id and ma.action='create' and ma.original_xml_request is not null with ur",
				originalXMLRequestRowMapper);
		assertEquals(400, originalXMLRequestOperations.getOriginalXml("1").getStatusCodeValue());

	}
}
