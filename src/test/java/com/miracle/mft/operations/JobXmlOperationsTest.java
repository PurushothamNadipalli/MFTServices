package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miracle.mft.model.JobXml;
import com.miracle.mft.operation.utils.JobXmlRowMapper;

@RunWith(PowerMockRunner.class)
public class JobXmlOperationsTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private JobXmlRowMapper jobXmlRowMapper;
	@InjectMocks
	JobXmlOperations jobXmlOperations;

	@Test
	public void testgetOriginalXml() {
		List<JobXml> jobXmls = new ArrayList<JobXml>();
		JobXml jobXml = new JobXml();
		jobXml.setJobXML("<jobXML></jobXML>");
		jobXmls.add(jobXml);
		PowerMockito.when(jdbcTemplate.query(
				"select MA.original_xml_request as JBXML from(select monitor,original_xml_request from FTELOG.monitor_action where original_xml_request is not null and original_xml_request like '<id>123</id>' order by ID desc  FETCH FIRST 1 ROWS only)MA inner join FTELOG.monitor M on M.ID=MA.monitor with ur",
				jobXmlRowMapper)).thenReturn(jobXmls);
		assertEquals(jobXmls, jobXmlOperations.getOriginalXml("<id>123</id>").getBody());

	}

	@Test
	public void testgetOriginalXmlException() {
		List<JobXml> jobXmls = new ArrayList<JobXml>();
		JobXml jobXml = new JobXml();
		jobXml.setJobXML("<jobXML></jobXML>");
		jobXmls.add(jobXml);
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select MA.original_xml_request as JBXML from(select monitor,original_xml_request from FTELOG.monitor_action where original_xml_request is not null and original_xml_request like '<id>123</id>' order by ID desc  FETCH FIRST 1 ROWS only)MA inner join FTELOG.monitor M on M.ID=MA.monitor with ur",
				jobXmlRowMapper);
		assertEquals(400, jobXmlOperations.getOriginalXml("<id>123</id>").getStatusCodeValue());
		assertTrue(true);

	}

}
