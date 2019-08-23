package com.miracle.mft.dbUtils;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

public class LoadGlobalPropertiesTest {

	@Test
	public void testLoadGlobalProperties() {
		System.setProperty("spring.global.filepath", "./src/test/resources/globalPropertiesTest.properties");
		LoadGlobalProperties.refreshGlobalProperties();
		// Test to global properties not null
		LoadGlobalProperties.refreshGlobalProperties();
		assertEquals("testUrl", System.getProperty("spring.datasource.url"));
	}

	@Test
	public void testLoadGlobalPropertiesException() {

		System.setProperty("spring.global.filepath", "globalPropertiesTest.properties");
		LoadGlobalProperties.refreshGlobalProperties();
		assertTrue(true);

	}

	@AfterClass
	public static void tearDown() {
		System.clearProperty("spring.datasource.url");
		System.clearProperty("spring.global.filepath");
		System.clearProperty("spring.datasource.username");
		System.clearProperty("spring.datasource.password");
		System.clearProperty("spring.jpa.show-sql");
		System.clearProperty("spring.datasource.driver.name");
	}

}
