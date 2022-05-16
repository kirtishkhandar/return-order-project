package com.returnordermanagementsystem.componentprocessing.response;

import java.time.LocalDate;

public class ProcessResponse {

	private String requestId;
	private int processingCharge;
	private int pakadgingAndDeliveryCharge;
	private LocalDate dateOfDelivery;

	public ProcessResponse() {
		super();
	}

	public ProcessResponse(String requestId, int processingCharge, int pakadgingAndDeliveryCharge, LocalDate dateOfDelivery) {
		super();
		this.requestId = requestId;
		this.processingCharge = processingCharge;
		this.pakadgingAndDeliveryCharge = pakadgingAndDeliveryCharge;
		this.dateOfDelivery = dateOfDelivery;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public int getProcessingCharge() {
		return processingCharge;
	}

	public void setProcessingCharge(int processingCharge) {
		this.processingCharge = processingCharge;
	}

	public int getPakadgingAndDeliveryCharge() {
		return pakadgingAndDeliveryCharge;
	}

	public void setPakadgingAndDeliveryCharge(int pakadgingAndDeliveryCharge) {
		this.pakadgingAndDeliveryCharge = pakadgingAndDeliveryCharge;
	}

	public LocalDate getDateOfDelivery() {
		return dateOfDelivery;
	}

	public void setDateOfDelivery(LocalDate dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}
}
