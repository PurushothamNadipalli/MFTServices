package com.miracle.mft.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.miracle.mft.model.JobXml;
import com.miracle.mft.model.MqmftHost;
import com.miracle.mft.model.MqmftUserExit;
import com.miracle.mft.model.OriginalXMLRequest;
import com.miracle.mft.model.UserExitDetails;
import com.miracle.mft.operations.JobXmlOperations;
import com.miracle.mft.operations.MqmftHostOperations;
import com.miracle.mft.operations.MqmftUserExitOperation;
import com.miracle.mft.operations.OriginalXMLRequestOperations;
import com.miracle.mft.operations.QueueManagerOperations;
import com.miracle.mft.operations.UserExitDetailsOperation;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MqmftUserExitOperation.class, UserExitDetailsOperation.class, QueueManagerOperations.class,
		OriginalXMLRequestOperations.class, JobXmlOperations.class })
public class MqMftUserExitControllerTest {

	@Mock
	MqmftUserExitOperation mqmftUserExitOperation;
	@Mock
	UserExitDetailsOperation userExitDetailsOperation;
	@Mock
	QueueManagerOperations queueManagerOperations;

	@Mock
	OriginalXMLRequestOperations OriginalXMLRequestOperations;
	@Mock
	JobXmlOperations jobXmlOperations;
	@InjectMocks
	MqMftUserExitController mqMftUserExitController;

	public void setUpupdateUserExitValue() {

		ResponseEntity response = new ResponseEntity<>("1 record Updated successsfully", HttpStatus.OK);
		PowerMockito.when(mqmftUserExitOperation.update(1, "type")).thenReturn(response);

	}

	@Test
	public void testupdateUserExitValue() {
		setUpupdateUserExitValue();
		ResponseEntity<?> res = mqMftUserExitController.updateUserExitValue(1, "type");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpinsertExitValue() {

		ResponseEntity response = new ResponseEntity<>("Record Has been inserted", HttpStatus.OK);
		PowerMockito.when(mqmftUserExitOperation.insert("1")).thenReturn(response);

	}

	@Test
	public void testinsertExitValue() {
		setUpinsertExitValue();
		ResponseEntity<?> res = mqMftUserExitController.insertExitValue("1");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetUserExitTypes() {
		List<MqmftUserExit> userExits = new ArrayList<MqmftUserExit>();
		MqmftUserExit exit = new MqmftUserExit();
		exit.setId(1);
		exit.setUserExitType("Exit");
		userExits.add(exit);
		ResponseEntity response = new ResponseEntity<>(userExits, HttpStatus.OK);
		PowerMockito.when(mqmftUserExitOperation.getuserExitYpes()).thenReturn(response);

	}

	@Test
	public void testgetUserExitTypes() {
		setUpgetUserExitTypes();
		ResponseEntity<?> res = mqMftUserExitController.getUserExitTypes();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetExitDetails() {
		List<UserExitDetails> userExitDetails = new ArrayList<UserExitDetails>();
		UserExitDetails exit = new UserExitDetails();
		exit.setExitParams("/dev");
		exit.setUserExitType("review");
		exit.setUserExitValue("2");
		userExitDetails.add(exit);
		ResponseEntity response = new ResponseEntity<>(userExitDetails, HttpStatus.OK);
		PowerMockito.when(userExitDetailsOperation.getValues()).thenReturn(response);

	}

	@Test
	public void testgetExitDetails() {
		setUpgetExitDetails();
		ResponseEntity<?> res = mqMftUserExitController.getExitDetails();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetOriginalXml() {
		List<OriginalXMLRequest> originalXMLRequests = new ArrayList<OriginalXMLRequest>();
		OriginalXMLRequest req = new OriginalXMLRequest();
		req.setMo_xml("XML");
		originalXMLRequests.add(req);
		ResponseEntity response = new ResponseEntity<>(originalXMLRequests, HttpStatus.OK);
		PowerMockito.when(OriginalXMLRequestOperations.getOriginalXml("121")).thenReturn(response);

	}

	@Test
	public void testgetOriginalXml() {
		setUpgetOriginalXml();
		ResponseEntity<?> res = mqMftUserExitController.getOriginalXml("121");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetJobXml() {
		List<JobXml> jobXmls = new ArrayList<JobXml>();
		JobXml jobXml = new JobXml();
		jobXml.setJobXML("<jobXML></jobXML>");
		jobXmls.add(jobXml);
		ResponseEntity response = new ResponseEntity<>(jobXmls, HttpStatus.OK);
		PowerMockito.when(jobXmlOperations.getOriginalXml("<xml>123</xml>")).thenReturn(response);

	}

	@Test
	public void testgetJobXml() {
		setUpgetJobXml();
		ResponseEntity<?> res = mqMftUserExitController.getJobXml("<xml>123</xml>");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}
}
