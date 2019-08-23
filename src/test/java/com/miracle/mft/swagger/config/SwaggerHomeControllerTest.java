package com.miracle.mft.swagger.config;

import static org.junit.Assert.*;

import org.junit.Test;

public class SwaggerHomeControllerTest {

	@Test
	public void test() {
		SwaggerHomeController swaggerHomeController = new SwaggerHomeController();
		assertNotNull(swaggerHomeController.homeIndex());
	}

}
