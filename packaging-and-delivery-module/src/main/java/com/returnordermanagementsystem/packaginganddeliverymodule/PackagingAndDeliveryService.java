package com.returnordermanagementsystem.packaginganddeliverymodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackagingAndDeliveryService {

	@Autowired
	Configuration config;

	public int getCharge(String componentType, int count) {
		if (componentType.equalsIgnoreCase("Integral"))
			return (config.getIntegralItemPackaging() + config.getIntegralItemDelivery()
					+ config.getProtectiveSheithPackaging()) * count;
		
		else if (componentType.equalsIgnoreCase("Accessory"))
			return (config.getAccessoryPackaging() + config.getAccessoryDelivery()
					+ config.getProtectiveSheithPackaging()) * count;
		
		else
			throw new RuntimeException("Wrong Component Type: " + componentType);

	}

}
