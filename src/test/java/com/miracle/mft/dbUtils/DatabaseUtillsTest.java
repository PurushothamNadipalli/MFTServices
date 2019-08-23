package com.miracle.mft.dbUtils;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.util.ReflectionTestUtils;


@RunWith(PowerMockRunner.class)
public class DatabaseUtillsTest {

	
	@Mock
	JdbcTemplate jdbcTemplate;
	@Mock
	DriverManagerDataSource driverManagerDataSource;
	@InjectMocks
	DatabaseUtills databaseUtills;

	@Test
	public void test() {
		try {
			ReflectionTestUtils.setField(databaseUtills, "driverNmae", "com.ibm.db2.jcc.DB2Driver");
			PowerMockito.whenNew(DriverManagerDataSource.class).withAnyArguments().thenReturn(driverManagerDataSource);
			PowerMockito.whenNew(JdbcTemplate.class).withAnyArguments().thenReturn(jdbcTemplate);
			assertNotNull(databaseUtills.getJdbcTemplate());
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
