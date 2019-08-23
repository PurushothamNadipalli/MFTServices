package com.miracle.mft.operations;

import static org.junit.Assert.*;

import java.sql.SQLException;
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
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miracle.mft.model.JobXml;
import com.miracle.mft.model.MqmftHost;
import com.miracle.mft.operation.utils.MqmftHostRowMapper;

@RunWith(PowerMockRunner.class)
public class MqmftHostOperationsTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private MqmftHostRowMapper mqmftHostRowMapper;
	int updateCount = 0;
	private List<MqmftHost> mqmftHosts;
	@InjectMocks
	MqmftHostOperations mqmftHostOperations;

	@Test
	public void testgetHosts() {
		mqmftHosts = new ArrayList<MqmftHost>();

		PowerMockito.when(
				jdbcTemplate.query("select * from FTELOG.MQMFT_HOST where deleted='N' with ur", mqmftHostRowMapper))
				.thenReturn(mqmftHosts);
		assertEquals(mqmftHosts, mqmftHostOperations.getHosts().getBody());

	}

	@Test
	public void testgetHostsException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.query("select * from FTELOG.MQMFT_HOST where deleted='N' with ur", mqmftHostRowMapper);
		assertEquals(400, mqmftHostOperations.getHosts().getStatusCodeValue());

	}

	@Test
	public void testupdate() {
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		host.setActive("Active");
		host.setAgentPort(1);
		host.setAgentQmgr("EB110005");
		host.setCoordPort(2);
		host.setCoordQmgr("COORDINATION Q MANAGER");
		host.setDefaultChannel("Channel");
		host.setDeleted("delete");
		host.setHostIp("IP");
		host.setHostName("hostname");
		host.setUserId("userId");
		PowerMockito.when(jdbcTemplate.update(
				"Update FTELOG.MQMFT_HOST set HOST_NAME='hostname',HOST_IP='IP',COORD_QMGR='COORDINATION Q MANAGER',COORD_PORT=2,AGENT_QMGR='EB110005',AGENT_PORT=1,DEFAULT_CHANNEL='Channel',USER_ID='userId',ACTIVE='Active' where HOST_ID=1"))
				.thenReturn(1);
		assertEquals(200, mqmftHostOperations.update(host).getStatusCodeValue());

	}

	@Test
	public void testUpdateException() {
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		host.setActive("Active");
		host.setAgentPort(1);
		host.setAgentQmgr("EB110005");
		host.setCoordPort(2);
		host.setCoordQmgr("COORDINATION Q MANAGER");
		host.setDefaultChannel("Channel");
		host.setDeleted("delete");
		host.setHostIp("IP");
		host.setHostName("hostname");
		host.setUserId("userId");
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).update(
				"Update FTELOG.MQMFT_HOST set HOST_NAME='hostname',HOST_IP='IP',COORD_QMGR='COORDINATION Q MANAGER',COORD_PORT=2,AGENT_QMGR='EB110005',AGENT_PORT=1,DEFAULT_CHANNEL='Channel',USER_ID='userId',ACTIVE='Active' where HOST_ID=1");
		assertEquals(400, mqmftHostOperations.update(host).getStatusCodeValue());

	}

	@Test
	public void testInsert() {
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		host.setActive("Active");
		host.setAgentPort(1);
		host.setAgentQmgr("EB110005");
		host.setCoordPort(2);
		host.setCoordQmgr("COORDINATION Q MANAGER");
		host.setDefaultChannel("Channel");
		host.setDeleted("delete");
		host.setHostIp("IP");
		host.setHostName("hostname");
		host.setUserId("userId");
		PowerMockito.doNothing().when(jdbcTemplate).execute(
				"Insert into FTELOG.MQMFT_HOST(HOST_NAME,HOST_IP,COORD_QMGR,COORD_PORT,AGENT_QMGR,AGENT_PORT,DEFAULT_CHANNEL,USER_ID,ACTIVE)VALUES('hostname','IP','COORDINATION Q MANAGER',2,'EB110005',1,'Channel','userId','Active')");
		assertEquals(200, mqmftHostOperations.insert(host).getStatusCodeValue());

	}

	@Test
	public void testInsertException() {
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		host.setActive("Active");
		host.setAgentPort(1);
		host.setAgentQmgr("EB110005");
		host.setCoordPort(2);
		host.setCoordQmgr("COORDINATION Q MANAGER");
		host.setDefaultChannel("Channel");
		host.setDeleted("delete");
		host.setHostIp("IP");
		host.setHostName("hostname");
		host.setUserId("userId");
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).execute(
				"Insert into FTELOG.MQMFT_HOST(HOST_NAME,HOST_IP,COORD_QMGR,COORD_PORT,AGENT_QMGR,AGENT_PORT,DEFAULT_CHANNEL,USER_ID,ACTIVE)VALUES('hostname','IP','COORDINATION Q MANAGER',2,'EB110005',1,'Channel','userId','Active')");
		assertEquals(400, mqmftHostOperations.insert(host).getStatusCodeValue());

	}

	@Test
	public void testDelete() {

		PowerMockito.doNothing().when(jdbcTemplate).execute("delete from FTELOG.MQMFT_HOST where Host_ID=1");
		assertEquals(200, mqmftHostOperations.delete(1).getStatusCodeValue());

	}

	@Test
	public void testDeleteException() {

		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.execute("delete from FTELOG.MQMFT_HOST where Host_ID=1");
		assertEquals(400, mqmftHostOperations.delete(1).getStatusCodeValue());

	}

}
