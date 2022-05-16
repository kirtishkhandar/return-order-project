package com.returnordermanagementsystem.componentprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnordermanagementsystem.componentprocessing.proxy.AuthorizationServiceProxy;
import com.returnordermanagementsystem.componentprocessing.request.PaymentRequest;
import com.returnordermanagementsystem.componentprocessing.request.ProcessRequest;
import com.returnordermanagementsystem.componentprocessing.response.PaymentResponse;
import com.returnordermanagementsystem.componentprocessing.response.ProcessResponse;
import com.returnordermanagementsystem.componentprocessing.service.PaymentService;
import com.returnordermanagementsystem.componentprocessing.service.ProcessingService;

@RestController
public class ComponentProcessingController {

	@Autowired
	@Qualifier("repair")
	ProcessingService repairService;

	@Autowired
	@Qualifier("replacement")
	ProcessingService replacementService;

	@Autowired
	PaymentService paymentService;
	
	@Autowired
	AuthorizationServiceProxy authProxy;

	@PostMapping("/ProcessDetail")
	public ProcessResponse retriveProcessResponse(@RequestHeader("Authorization") String token, @RequestBody ProcessRequest request) {
		if(authProxy.validateToken(token)) {
		if (null != request.getComponentType() && request.getComponentType().equalsIgnoreCase("Integral"))
			return repairService.getDetails(request);

		else if (null != request.getComponentType() && request.getComponentType().equalsIgnoreCase("Accessory"))
			return replacementService.getDetails(request);
		
		else
			throw new RuntimeException("Wrong ComponentType");
		}
		else 
			throw new RuntimeException("Invalid Token");
	}

	@PostMapping("/CompleteProcessing")
	public PaymentResponse executeProcessing(@RequestHeader("Authorization") String token, @RequestBody PaymentRequest request) {
		if(authProxy.validateToken(token))
			return paymentService.makePayment(request);
		else 
			throw new RuntimeException("Invalid Token");

	}

}
