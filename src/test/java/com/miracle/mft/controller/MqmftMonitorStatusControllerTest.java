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
import com.miracle.mft.model.MqmftMonitorStatus;
import com.miracle.mft.operations.MqmftHostOperations;
import com.miracle.mft.operations.MqmftMonitorStatusOperations;
import com.miracle.mft.operations.MqmftMonitors;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MqmftMonitorStatusOperations.class })
public class MqmftMonitorStatusControllerTest {

	@Mock
	MqmftMonitorStatusOperations monitorStatusOperations;
	@InjectMocks
	MqmftMonitorStatusController mqmftMonitorStatusController;

	public void setUpgetMonitorStatus() {
		List<MqmftMonitorStatus> mqmftMonitorStatusList = new ArrayList<MqmftMonitorStatus>();
		MqmftMonitorStatus status = new MqmftMonitorStatus();
		status.setMonitorNames("Monitor");
		status.setHostId(12);
		mqmftMonitorStatusList.add(status);
		ResponseEntity response = new ResponseEntity<>(mqmftMonitorStatusList, HttpStatus.OK);
		PowerMockito.when(monitorStatusOperations.getMonitorStatus()).thenReturn(response);

	}

	@Test
	public void testgetMonitorStatus() {
		setUpgetMonitorStatus();
		ResponseEntity<?> res = mqmftMonitorStatusController.getMonitorStatus();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetMonitors() {
		List<MqmftMonitors> mqmftMonitors = new ArrayList<MqmftMonitors>();
		MqmftMonitors monitors = new MqmftMonitors();
		monitors.setAgent("agent");
		monitors.setMonitor_ID("Mid");
		monitors.setMonitorName("mname");
		monitors.setMxml("mxml");
		monitors.setQMGR("Qmanager");
		monitors.setStatus("mstatus");
		mqmftMonitors.add(monitors);
		ResponseEntity response = new ResponseEntity<>(mqmftMonitors, HttpStatus.OK);
		PowerMockito.when(monitorStatusOperations.getMonitors()).thenReturn(response);

	}

	@Test
	public void testgetMonitors() {
		setUpgetMonitors();
		ResponseEntity<?> res = mqmftMonitorStatusController.getMonitors();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpinsertHosts() {

		ResponseEntity response = new ResponseEntity<>("Record Inserted successfully", HttpStatus.OK);
		PowerMockito.when(monitorStatusOperations.insertMoniterStatus(Mockito.any())).thenReturn(response);

	}

	@Test
	public void testinsertHosts() {
		setUpinsertHosts();
		MqmftMonitorStatus status = new MqmftMonitorStatus();
		status.setMonitorNames("Monitor");
		status.setHostId(12);
		ResponseEntity<?> res = mqmftMonitorStatusController.insertHosts(status);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	@Test
	public void testDelete() {
		ResponseEntity response = new ResponseEntity<>("Record Deleted successfully", HttpStatus.OK);
		PowerMockito.when(monitorStatusOperations.delete(1, "monitor")).thenReturn(response);

		mqmftMonitorStatusController.deleteMonitors(1, "monitor");
	}
}
