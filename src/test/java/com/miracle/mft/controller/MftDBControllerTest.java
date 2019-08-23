package com.miracle.mft.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.miracle.mft.model.MqmftUserExitDetail;
import com.miracle.mft.model.Transfer;
import com.miracle.mft.model.TransferLog;
import com.miracle.mft.model.TransferValues;
import com.miracle.mft.operations.MQMftUserExistDetailsOperation;
import com.miracle.mft.operations.TransferFileLogOperations;
import com.miracle.mft.operations.TransferOperation;
import com.miracle.mft.operations.TransferValueOperation;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ TransferValueOperation.class, TransferOperation.class, MQMftUserExistDetailsOperation.class,
		TransferFileLogOperations.class })
public class MftDBControllerTest {

	@Mock
	TransferValueOperation transferValueOperation;
	@Mock
	TransferOperation transferOperation;
	@Mock
	MQMftUserExistDetailsOperation mQMftUserExistDetailsOperation;
	@Mock
	TransferFileLogOperations transferFileLogOperations;

	@InjectMocks
	MftDBController mftDBController;

	public void setUpTransferValues() {
		List<TransferValues> transferValues = new ArrayList<TransferValues>();
		TransferValues values = new TransferValues();
		values.setDestinationFilename("detFileName");
		values.setDestinationMessageQueueName("dstQueueManager");
		values.setKey("key");
		values.setSourceFilename("sourceFileName");
		values.setValue("value");
		transferValues.add(values);
		ResponseEntity response = new ResponseEntity<>(transferValues, HttpStatus.OK);
		PowerMockito.when(transferValueOperation.getData("123")).thenReturn(response);

	}

	public void setUpTransfer() {
		List<Transfer> transferValues = new ArrayList<Transfer>();
		Transfer values = new Transfer();
		values.setTransferId("jobName");
		transferValues.add(values);
		ResponseEntity response = new ResponseEntity<>(transferValues, HttpStatus.OK);
		PowerMockito.when(transferOperation.getData()).thenReturn(response);

	}

	@Test
	public void testGetTransferValues() {
		setUpTransferValues();
		ResponseEntity<?> res = mftDBController.getTransferValues("123");
		System.out.println(res.getStatusCode());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	@Test
	public void testGetJobNames() {
		setUpTransfer();
		ResponseEntity<?> res = mftDBController.getJobNames();
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpUpdateDeleteUserExitValue() {
		ResponseEntity response = new ResponseEntity<>("one record updated", HttpStatus.OK);
		PowerMockito.when(mQMftUserExistDetailsOperation.update(1)).thenReturn(response);

	}

	@Test
	public void testUpdateDeleteUserExitValue() {
		setUpUpdateDeleteUserExitValue();
		ResponseEntity<?> res = mftDBController.updateDeleteUserExitValue(1);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpInsertUserExitValue() {
		ResponseEntity response = new ResponseEntity<>("Record Inserted", HttpStatus.OK);
		PowerMockito.when(mQMftUserExistDetailsOperation.insert(1, "userExitValue", "parames")).thenReturn(response);

	}

	@Test
	public void testInsertUserExitValue() {
		setUpInsertUserExitValue();
		ResponseEntity<?> res = mftDBController.InsertUserExitValue(1, "userExitValue", "parames");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpupdateUserExitValue() {
		ResponseEntity response = new ResponseEntity<>("Record Updated", HttpStatus.OK);
		PowerMockito.when(mQMftUserExistDetailsOperation.UpdateValues(1, "userExitValue", "parames"))
				.thenReturn(response);

	}

	@Test
	public void testupdateUserExitValue() {
		setUpupdateUserExitValue();
		ResponseEntity<?> res = mftDBController.updateUserExitValue(1, "userExitValue", "parames");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetUserExitValues() {
		List<MqmftUserExitDetail> userDetails = new ArrayList<MqmftUserExitDetail>();
		MqmftUserExitDetail detail = new MqmftUserExitDetail();
		detail.setExitId(23);
		detail.setDeleted("yes");
		detail.setExitParams("params");
		detail.setId(1234);
		detail.setUserExitValue("userExitValue");
		userDetails.add(detail);
		ResponseEntity response = new ResponseEntity<>(userDetails, HttpStatus.OK);
		PowerMockito.when(mQMftUserExistDetailsOperation.getValues(1)).thenReturn(response);

	}

	@Test
	public void testGetUserExitValues() {
		setUpgetUserExitValues();
		ResponseEntity<?> res = mftDBController.getUserExitValues(1);
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

	public void setUpgetTransferLogs() {
		List<TransferLog> transferLogs = new ArrayList<TransferLog>();
		TransferLog log = new TransferLog();
		log.setCompleteId(234123);
		log.setDestinationFilename("/usr");
		log.setDestinationFileSize(23456);
		log.setEndTime("12:34");
		log.setFileResult(23456);
		log.setFileResultMessage("message");
		log.setJobName("job");
		log.setNumberOfFiles(345);
		log.setOverAllResultText("True");
		log.setRelatedTransferId("2345");
		log.setResultcode(1234);
		log.setResultText("Dummt");
		transferLogs.add(log);
		ResponseEntity response = new ResponseEntity<>(transferLogs, HttpStatus.OK);
		PowerMockito.when(transferFileLogOperations.getTransferLog("10-5-2019", "10-6-2019", "sample"))
				.thenReturn(response);

	}

	@Test
	public void testgetTransferLogs() {
		setUpgetTransferLogs();
		ResponseEntity<?> res = mftDBController.getTransferLogs("10-5-2019", "10-6-2019", "sample");
		System.out.println(res.getBody());
		assertEquals(HttpStatus.OK, res.getStatusCode());
	}

}
