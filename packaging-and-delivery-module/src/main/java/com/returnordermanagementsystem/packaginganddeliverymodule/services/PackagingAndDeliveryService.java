package com.returnordermanagementsystem.packaginganddeliverymodule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanagementsystem.packaginganddeliverymodule.config.Configuration;

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
			throw new IllegalArgumentException(String.format("Wrong Component Type: %s ", componentType));

	}

}
