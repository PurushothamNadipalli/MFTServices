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

import com.miracle.mft.model.MqmftHost;
import com.miracle.mft.model.TransferLog;
import com.miracle.mft.operations.MQMftUserExistDetailsOperation;
import com.miracle.mft.operations.MqmftHostOperations;
import com.miracle.mft.operations.TransferFileLogOperations;
import com.miracle.mft.operations.TransferOperation;
import com.miracle.mft.operations.TransferValueOperation;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MqmftHostOperations.class })
public class MqMftHostControllerTest {

	@Mock
	MqmftHostOperations mqmftHostOperations;
	@InjectMocks
	MqMftHostController mqMftHostController;

	public void setUpgetTransferLogs() {
		List<MqmftHost> mqmftHosts = new ArrayList<MqmftHost>();
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
		mqmftHosts.add(host);
		ResponseEntity response = new ResponseEntity<>(mqmftHosts, HttpStatus.OK);
		PowerMockito.when(mqmftHostOperations.getHosts()).thenReturn(response);

	}

	@Test
	public void testgetHosts() {
		setUpgetTransferLogs();
		ResponseEntity<?> res = mqMftHostController.getHosts();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpinsertHosts() {

		ResponseEntity response = new ResponseEntity<>("Record Inserted successfully", HttpStatus.OK);
		PowerMockito.when(mqmftHostOperations.insert(Mockito.any())).thenReturn(response);

	}

	@Test
	public void testinsertHosts() {
		setUpinsertHosts();
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		host.setActive("Active");
		ResponseEntity<?> res = mqMftHostController.insertHosts(host);
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}
	
	public void setUpupdateHosts() {

		ResponseEntity response = new ResponseEntity<>("Record Updated successfully", HttpStatus.OK);
		PowerMockito.when(mqmftHostOperations.update(Mockito.any())).thenReturn(response);

	}

	@Test
	public void testupdateHosts() {
		setUpupdateHosts();
		MqmftHost host = new MqmftHost();
		host.setHostId(1);
		host.setActive("Active");
		ResponseEntity<?> res = mqMftHostController.updateHosts(host);
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}
	
	public void setUpdeleteHosts() {

		ResponseEntity response = new ResponseEntity<>("Record deleted successfully", HttpStatus.OK);
		PowerMockito.when(mqmftHostOperations.delete(1)).thenReturn(response);

	}

	@Test
	public void testdeleteHosts() {
		setUpdeleteHosts();
		ResponseEntity<?> res = mqMftHostController.deleteHosts(1);
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

}
