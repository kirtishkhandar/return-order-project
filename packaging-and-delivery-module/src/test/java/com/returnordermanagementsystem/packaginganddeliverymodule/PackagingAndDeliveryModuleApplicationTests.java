package com.returnordermanagementsystem.packaginganddeliverymodule;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.returnordermanagementsystem.packaginganddeliverymodule.services.PackagingAndDeliveryService;

@SpringBootTest
class PackagingAndDeliveryModuleApplicationTests {
	
	@Autowired
	PackagingAndDeliveryService service;
	
	@Test
	void testIntegral() {
		assertEquals(3500, service.getCharge("Integral", 10));
	}
	
	@Test
	void testAccessory() {
		assertEquals(2000, service.getCharge("Accessory", 10));
	}

}
