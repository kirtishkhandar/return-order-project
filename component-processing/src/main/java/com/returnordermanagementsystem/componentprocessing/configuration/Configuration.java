package com.returnordermanagementsystem.componentprocessing.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("return-service")
public class Configuration {

	private int repairProcessingDays;
	private int repairProcessingCharge;
	private int replacementProcessingDays;
	private int replacementProcessingCharge;

	public int getRepairProcessingDays() {
		return repairProcessingDays;
	}

	public void setRepairProcessingDays(int repairProcessingDays) {
		this.repairProcessingDays = repairProcessingDays;
	}

	public int getRepairProcessingCharge() {
		return repairProcessingCharge;
	}

	public void setRepairProcessingCharge(int repairProcessingCharge) {
		this.repairProcessingCharge = repairProcessingCharge;
	}

	public int getReplacementProcessingDays() {
		return replacementProcessingDays;
	}

	public void setReplacementProcessingDays(int replacementProcessingDays) {
		this.replacementProcessingDays = replacementProcessingDays;
	}

	public int getReplacementProcessingCharge() {
		return replacementProcessingCharge;
	}

	public void setReplacementProcessingCharge(int replacementProcessingCharge) {
		this.replacementProcessingCharge = replacementProcessingCharge;
	}
	
	
}
