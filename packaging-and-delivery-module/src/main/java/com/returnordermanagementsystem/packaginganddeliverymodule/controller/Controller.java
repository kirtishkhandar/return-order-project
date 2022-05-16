package com.returnordermanagementsystem.packaginganddeliverymodule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagementsystem.packaginganddeliverymodule.PackagingAndDeliveryService;

@RestController
public class Controller {

	@Autowired
	PackagingAndDeliveryService service;

	@GetMapping("/GetPackagingDeliveryCharge/{componentType}/{count}")
	public int getDetails(@PathVariable String componentType, @PathVariable int count) {
		return service.getCharge(componentType, count);
	}

}
