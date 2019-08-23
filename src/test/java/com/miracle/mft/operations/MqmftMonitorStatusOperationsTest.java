package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
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

import com.miracle.mft.model.MqmftHost;
import com.miracle.mft.model.MqmftMonitorStatus;
import com.miracle.mft.operation.utils.MqmftMonitorStatusRowMapper;

@RunWith(PowerMockRunner.class)
public class MqmftMonitorStatusOperationsTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private MqmftMonitorStatusRowMapper mqmftMonitorStatusRowMapper;
	@Mock
	private MqmftMonitorRowMapper mqmftMonitorRowMapper;
	@InjectMocks
	MqmftMonitorStatusOperations monitorStatusOperations;
	List<MqmftMonitorStatus> mqmftMonitorStatusList;
	List<MqmftMonitors> mqmftMonitors;

	@Test
	public void testgetMonitorStatus() {
		mqmftMonitorStatusList = new ArrayList<MqmftMonitorStatus>();

		PowerMockito.when(jdbcTemplate.query(
				"select distinct Monitor_Name as MonitorNames from FTELOG.MQMFT_MONITORSTATUS with ur",
				mqmftMonitorStatusRowMapper)).thenReturn(mqmftMonitorStatusList);
		assertEquals(mqmftMonitorStatusList, monitorStatusOperations.getMonitorStatus().getBody());

	}

	@Test
	public void testgetMonitorStatusException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select distinct Monitor_Name as MonitorNames from FTELOG.MQMFT_MONITORSTATUS with ur",
				mqmftMonitorStatusRowMapper);
		assertEquals(400, monitorStatusOperations.getMonitorStatus().getStatusCodeValue());

	}

	@Test
	public void testgetMonitors() {
		mqmftMonitors = new ArrayList<MqmftMonitors>();

		PowerMockito.when(jdbcTemplate.query(
				"select p.id as ID,p.action as Status,os.name as MonitorName,os.agent as Agent, os.qmgr as QMGR,os.Monitor_ID, mx.original_xml_request as mxml from (select max(ss.id) as id,ss.Monitor_ID, ss.name,ss.agent,ss.qmgr from (select MA.ID,MA.Action,M.ID as Monitor_ID, M.Name,M.Agent,M.QMGR from FTELOG.monitor_action ma inner join FTELOG.monitor m on ma.monitor=m.id order by MA.ID )ss group by ss.Monitor_ID, ss.name,ss.agent,ss.qmgr) as os inner join FTELOG.monitor_action P on p.id=os.id inner join FTELOG.monitor_action mx on mx.monitor = p.monitor and mx.action = 'create' where os.monitor_id not in ( select Monitor_Name from FTELOG.MQMFT_MONITORSTATUS) order by p.id asc with ur",
				mqmftMonitorRowMapper)).thenReturn(mqmftMonitors);
		assertEquals(mqmftMonitors, monitorStatusOperations.getMonitors().getBody());

	}

	@Test
	public void testgetMonitorsException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"select p.id as ID,p.action as Status,os.name as MonitorName,os.agent as Agent, os.qmgr as QMGR,os.Monitor_ID, mx.original_xml_request as mxml from (select max(ss.id) as id,ss.Monitor_ID, ss.name,ss.agent,ss.qmgr from (select MA.ID,MA.Action,M.ID as Monitor_ID, M.Name,M.Agent,M.QMGR from FTELOG.monitor_action ma inner join FTELOG.monitor m on ma.monitor=m.id order by MA.ID )ss group by ss.Monitor_ID, ss.name,ss.agent,ss.qmgr) as os inner join FTELOG.monitor_action P on p.id=os.id inner join FTELOG.monitor_action mx on mx.monitor = p.monitor and mx.action = 'create' where os.monitor_id not in ( select Monitor_Name from FTELOG.MQMFT_MONITORSTATUS) order by p.id asc with ur",
				mqmftMonitorRowMapper);
		assertEquals(400, monitorStatusOperations.getMonitors().getStatusCodeValue());

	}

	@Test
	public void testinsertMoniterStatus() {
		MqmftMonitorStatus status = new MqmftMonitorStatus();
		status.setMonitorNames("Monitor");
		status.setHostId(12);
		PowerMockito.doNothing().when(jdbcTemplate)
				.execute("INSERT INTO FTELOG.MQMFT_MONITORSTATUS (HOST_ID,Monitor_Name)values(12,'Monitor')");
		assertEquals(200, monitorStatusOperations.insertMoniterStatus(status).getStatusCodeValue());

	}

	@Test
	public void testinsertMoniterStatusException() {
		MqmftMonitorStatus status = new MqmftMonitorStatus();
		status.setMonitorNames("Monitor");
		status.setHostId(12);
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.execute("INSERT INTO FTELOG.MQMFT_MONITORSTATUS (HOST_ID,Monitor_Name)values(12,'Monitor')");
		assertEquals(400, monitorStatusOperations.insertMoniterStatus(status).getStatusCodeValue());

	}

	@Test
	public void testdelete() {

		PowerMockito.doNothing().when(jdbcTemplate)
				.execute("delete from FTELOG.MQMFT_MONITORSTATUS where Monitor_Name=Monitor and HOST_ID=12");
		assertEquals(200, monitorStatusOperations.delete(12, "Monitor").getStatusCodeValue());

	}

	@Test
	public void testdeleteException() {

		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.execute("delete from FTELOG.MQMFT_MONITORSTATUS where Monitor_Name=Monitor and HOST_ID=12");
		assertEquals(400, monitorStatusOperations.delete(12, "Monitor").getStatusCodeValue());

	}

}
