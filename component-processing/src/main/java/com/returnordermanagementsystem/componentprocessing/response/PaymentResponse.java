package com.returnordermanagementsystem.componentprocessing.response;

public class PaymentResponse {
	private String paymentId;
	private String requestId;
	private int processingCharge;
	private boolean paymentSuccess;

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
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

	public boolean isPaymentSuccess() {
		return paymentSuccess;
	}

	public void setPaymentSuccess(boolean paymentSuccess) {
		this.paymentSuccess = paymentSuccess;
	}

}
