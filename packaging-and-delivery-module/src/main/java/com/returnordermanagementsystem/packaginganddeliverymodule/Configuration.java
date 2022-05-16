package com.returnordermanagementsystem.packaginganddeliverymodule;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("packing-delivery")
public class Configuration {

	private int integralItemPackaging;
	private int accessoryPackaging;
	private int protectiveSheithPackaging;
	private int integralItemDelivery;
	private int accessoryDelivery;

	public int getIntegralItemPackaging() {
		return integralItemPackaging;
	}

	public void setIntegralItemPackaging(int integralItemPackaging) {
		this.integralItemPackaging = integralItemPackaging;
	}

	public int getAccessoryPackaging() {
		return accessoryPackaging;
	}

	public void setAccessoryPackaging(int accessoryPackaging) {
		this.accessoryPackaging = accessoryPackaging;
	}

	public int getProtectiveSheithPackaging() {
		return protectiveSheithPackaging;
	}

	public void setProtectiveSheithPackaging(int protectiveSheithPackaging) {
		this.protectiveSheithPackaging = protectiveSheithPackaging;
	}

	public int getIntegralItemDelivery() {
		return integralItemDelivery;
	}

	public void setIntegralItemDelivery(int integralItemDelivery) {
		this.integralItemDelivery = integralItemDelivery;
	}

	public int getAccessoryDelivery() {
		return accessoryDelivery;
	}

	public void setAccessoryDelivery(int accessoryDelivery) {
		this.accessoryDelivery = accessoryDelivery;
	}
}
