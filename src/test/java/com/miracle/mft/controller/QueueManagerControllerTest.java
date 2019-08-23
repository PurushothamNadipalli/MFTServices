package com.miracle.mft.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.miracle.mft.model.QueueManager;
import com.miracle.mft.operations.JobXmlOperations;
import com.miracle.mft.operations.MqmftUserExitOperation;
import com.miracle.mft.operations.OriginalXMLRequestOperations;
import com.miracle.mft.operations.QueueManagerOperations;
import com.miracle.mft.operations.UserExitDetailsOperation;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ QueueManagerOperations.class })
public class QueueManagerControllerTest {

	@Mock
	QueueManagerOperations queueManagerOperations;
	@InjectMocks
	QueueManagerController queueManagerController;

	public void setUpgetQueueManagers() {
		List<QueueManager> queueManagers = new ArrayList<QueueManager>();
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
		queueManagers.add(mgr);
		ResponseEntity response = new ResponseEntity<>(queueManagers, HttpStatus.OK);
		PowerMockito.when(queueManagerOperations.getQueueManagers()).thenReturn(response);

	}

	@Test
	public void testgetQueueManagers() {
		setUpgetQueueManagers();
		ResponseEntity<?> res = queueManagerController.getQueueManagers();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpinsertQueueManagers() {

		ResponseEntity response = new ResponseEntity<>("Records inserted successfully", HttpStatus.OK);
		PowerMockito.when(queueManagerOperations.insertQueueManagers(Mockito.any())).thenReturn(response);

	}

	@Test
	public void testinsertQueueManagers() {
		setUpinsertQueueManagers();
		QueueManager mgr = new QueueManager();
		mgr.setHost_ip("234");
		mgr.setHost_name("host");
		ResponseEntity<?> res = queueManagerController.insertQueueManagers(mgr);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpupdateQueueManagers() {

		ResponseEntity response = new ResponseEntity<>("Records Update successfully", HttpStatus.OK);
		PowerMockito.when(queueManagerOperations.updateQueueManagers(Mockito.any())).thenReturn(response);

	}

	@Test
	public void testupdateQueueManagers() {
		setUpupdateQueueManagers();
		QueueManager mgr = new QueueManager();
		mgr.setHost_ip("234");
		mgr.setHost_name("host");
		ResponseEntity<?> res = queueManagerController.updateQueueManagers(mgr);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpdeleteQueueManagers() {

		ResponseEntity response = new ResponseEntity<>("Records deleted successfully", HttpStatus.OK);
		PowerMockito.when(queueManagerOperations.deleteQueueManager(1)).thenReturn(response);

	}

	@Test
	public void testdeleteQueueManagers() {
		setUpdeleteQueueManagers();
		ResponseEntity<?> res = queueManagerController.deleteQueueManagers(1);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

}
