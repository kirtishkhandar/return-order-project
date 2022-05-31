package com.returnordermanagementsystem.componentprocessing.service.impl;

import java.time.LocalDate;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.returnordermanagementsystem.componentprocessing.configuration.Configuration;
import com.returnordermanagementsystem.componentprocessing.entity.ProcessEntity;
import com.returnordermanagementsystem.componentprocessing.proxy.PackageAndDeliveryModuleProxy;
import com.returnordermanagementsystem.componentprocessing.repository.ProcessEntityRepository;
import com.returnordermanagementsystem.componentprocessing.request.ProcessRequest;
import com.returnordermanagementsystem.componentprocessing.response.ProcessResponse;
import com.returnordermanagementsystem.componentprocessing.service.ProcessingService;

@Service
@Qualifier("replacement")
public class ReplacementProcessing implements ProcessingService {

	@Autowired
	Configuration config;

	@Autowired
	ProcessEntityRepository repo;

	@Autowired
	PackageAndDeliveryModuleProxy proxy;

	private static final Logger logger = LoggerFactory.getLogger(ReplacementProcessing.class);

	@Override
	public ProcessResponse getDetails(ProcessRequest request) {

		ProcessEntity processEntity = new ProcessEntity();
		BeanUtils.copyProperties(request, processEntity);

		LocalDate date = LocalDate.now().plusDays(config.getReplacementProcessingDays());

		processEntity.setRequestId(UUID.randomUUID().toString().replace("-", ""));
		processEntity.setProcessingCharge(config.getReplacementProcessingCharge());
		processEntity.setDateOfDelivery(date);
		processEntity
				.setPakadgingAndDeliveryCharge(proxy.getDetails(request.getComponentType(), request.getQuantity()));

		logger.info("Inside Replacement Service. Component type:"+request.getComponentType()+ "Request Quantity"+ request.getQuantity());

		ProcessResponse processResponse = new ProcessResponse();
		BeanUtils.copyProperties(processEntity, processResponse);

		repo.save(processEntity);

		return processResponse;
	}

}
