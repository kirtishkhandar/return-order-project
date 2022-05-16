package com.returnordermanagementsystem.componentprocessing.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentEntity {
	@Id
	private String paymentId;

	private String requestId;
	private int creditCardNumber;
	private int creditlimit;
	private int processingCharge;
	private boolean paymentSuccess;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String uuid) {
		this.paymentId = uuid;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public int getCreditlimit() {
		return creditlimit;
	}

	public void setCreditlimit(int creditlimit) {
		this.creditlimit = creditlimit;
	}

	public int getProcessingCharge() {
		return processingCharge;
	}

	public void setProcessingCharge(int processingCharge) {
		this.processingCharge = processingCharge;
	}

	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}

	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}

}
