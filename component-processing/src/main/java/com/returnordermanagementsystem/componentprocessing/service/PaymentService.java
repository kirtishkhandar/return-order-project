package com.returnordermanagementsystem.componentprocessing.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanagementsystem.componentprocessing.entity.PaymentEntity;
import com.returnordermanagementsystem.componentprocessing.entity.ProcessEntity;
import com.returnordermanagementsystem.componentprocessing.repository.PaymentEntityRepository;
import com.returnordermanagementsystem.componentprocessing.repository.ProcessEntityRepository;
import com.returnordermanagementsystem.componentprocessing.request.PaymentRequest;
import com.returnordermanagementsystem.componentprocessing.response.PaymentResponse;

@Service
public class PaymentService {

	@Autowired
	ProcessEntityRepository processRepo;
	
	@Autowired
	PaymentEntityRepository paymentRepo;

	public PaymentResponse makePayment(PaymentRequest request) {
		if(processRepo.existsById(request.getRequestId())) {
			ProcessEntity processEntity = processRepo.getById(request.getRequestId());
			if(processEntity.getProcessingCharge()==request.getProcessingCharge()) {
				
				PaymentEntity paymentEntity = new PaymentEntity();
				paymentEntity.setPaymentId(UUID.randomUUID().toString().replace("-", ""));
				paymentEntity.setPaymentSuccess(true);
				BeanUtils.copyProperties(request, paymentEntity);
				paymentRepo.save(paymentEntity);

				BeanUtils.copyProperties(paymentEntity, processEntity);
				processRepo.save(processEntity);
				
				PaymentResponse paymentResponse = new PaymentResponse();
				BeanUtils.copyProperties(processEntity, paymentResponse);
				return paymentResponse;
			}
			else
				throw new IllegalArgumentException(String.format("Incorrect ProcessingCharge: %d", request.getProcessingCharge()));
		}
		else 
			throw new IllegalArgumentException(String.format("Request ID: %s does not exist", request.getRequestId()));
	}

}
