package com.miracle.mft.operations;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.miracle.mft.model.QueueManager;
import com.miracle.mft.operation.utils.QueueManagerRowMapper;

@RunWith(PowerMockRunner.class)
public class QueueManagerOperationsTest {
	@Mock
	private JdbcTemplate jdbcTemplate;
	@Mock
	private QueueManagerRowMapper queueManagerRowMapper;
	private List<QueueManager> queueManagers;
	@InjectMocks
	QueueManagerOperations queueManagerOperations;

	@Test
	public void testgetQueueManagers() {
		PowerMockito.when(jdbcTemplate.query(
				"SELECT qm.*,host.host_name, host.host_ip FROM FTELOG.MQMFT_QM_DETAILS qm inner join FTELOG.MQMFT_HOST host on qm.HOST_ID = host.HOST_ID with ur",
				queueManagerRowMapper)).thenReturn(null);
		assertEquals(200, queueManagerOperations.getQueueManagers().getStatusCodeValue());

	}

	@Test
	public void testgetQueueManagersException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).query(
				"SELECT qm.*,host.host_name, host.host_ip FROM FTELOG.MQMFT_QM_DETAILS qm inner join FTELOG.MQMFT_HOST host on qm.HOST_ID = host.HOST_ID with ur",
				queueManagerRowMapper);
		assertEquals(400, queueManagerOperations.getQueueManagers().getStatusCodeValue());

	}

	@Test
	public void testdeleteQueueManager() {
		PowerMockito.doNothing().when(jdbcTemplate).execute("delete from  FTELOG.MQMFT_QM_DETAILS  where QMID=1");
		assertEquals(200, queueManagerOperations.deleteQueueManager(1).getStatusCodeValue());

	}

	@Test
	public void testdeleteQueueManagerException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate)
				.execute("delete from  FTELOG.MQMFT_QM_DETAILS  where QMID=1");
		assertEquals(400, queueManagerOperations.deleteQueueManager(1).getStatusCodeValue());

	}

	@Test
	public void testinsertQueueManagers() {

		PowerMockito.doNothing().when(jdbcTemplate).execute(
				"insert into FTELOG.MQMFT_QM_DETAILS  (QM_NAME,QM_CHANNEL,QM_PORT,QM_USERID,IS_AGENT,IS_CMND,IS_COORD,IS_ACTIVE,HOST_ID) values  ('qmname','chaneel',12,'user','false','cmd','Coord','true',1)");
		assertEquals(200, queueManagerOperations.insertQueueManagers(buildQueueManager()).getStatusCodeValue());

	}

	@Test
	public void testinsertQueueManagersException() {

		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).execute(
				"insert into FTELOG.MQMFT_QM_DETAILS  (QM_NAME,QM_CHANNEL,QM_PORT,QM_USERID,IS_AGENT,IS_CMND,IS_COORD,IS_ACTIVE,HOST_ID) values  ('qmname','chaneel',12,'user','false','cmd','Coord','true',1)");
		assertEquals(400, queueManagerOperations.insertQueueManagers(buildQueueManager()).getStatusCodeValue());

	}

	@Test
	public void testUpdate() {
		PowerMockito.when(jdbcTemplate.update(
				"update FTELOG.MQMFT_QM_DETAILS  set QM_NAME='qmname',QM_CHANNEL='chaneel',QM_PORT=12,QM_USERID='user',IS_AGENT='false',IS_CMND='cmd',IS_COORD='Coord',IS_ACTIVE='true',HOST_ID=1 where QMID=12"))
				.thenReturn(1);
		assertEquals(200, queueManagerOperations.updateQueueManagers(buildQueueManager()).getStatusCodeValue());

	}

	@Test
	public void testUpdateException() {
		PowerMockito.doThrow(new InvalidResultSetAccessException(new SQLException())).when(jdbcTemplate).update(
				"update FTELOG.MQMFT_QM_DETAILS  set QM_NAME='qmname',QM_CHANNEL='chaneel',QM_PORT=12,QM_USERID='user',IS_AGENT='false',IS_CMND='cmd',IS_COORD='Coord',IS_ACTIVE='true',HOST_ID=1 where QMID=12");
		assertEquals(400, queueManagerOperations.updateQueueManagers(buildQueueManager()).getStatusCodeValue());

	}

	public QueueManager buildQueueManager() {
		QueueManager mgr = new QueueManager();
		mgr.setHost_ip("234");
		mgr.setHost_name("host");
		mgr.setHostId(1);
		mgr.setIsActive("true");
		mgr.setIsAgent("false");
		mgr.setIsCmnd("cmd");
		mgr.setIsCoord("Coord");
		mgr.setQmChannel("chaneel");
		mgr.setQmid(12);
		mgr.setQmName("qmname");
		mgr.setQmPort(12);
		mgr.setQmUserid("user");
		return mgr;
	}
}
