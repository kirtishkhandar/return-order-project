package com.returnordermanagementsystem.packaginganddeliverymodule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PackagingAndDeliveryModuleApplicationTests {
	
	@Autowired
	PackagingAndDeliveryService service;
	
	@Test
	public void testIntegral() {
		assertEquals(3500, service.getCharge("Integral", 10));
	}
	
	@Test
	public void testAccessory() {
		assertEquals(2000, service.getCharge("Accessory", 10));
	}

}
