package com.returnordermanagementsystem.componentprocessing.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProcessEntity {

	private String name;
	private String contactNumber;
	private String componentType;
	private String componentName;
	private int quantity;
	
	@Id
	private String requestId;
	private int processingCharge;
	private int pakadgingAndDeliveryCharge;
	private LocalDate dateOfDelivery;

	private boolean paymentSuccess;
	private String paymentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getComponentType() {
		return componentType;
	}

	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String uuid) {
		this.requestId = uuid;
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

	public void setDateOfDelivery(LocalDate date) {
		this.dateOfDelivery = date;
	}

	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}

	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String string) {
		this.paymentId = string;
	}

}
