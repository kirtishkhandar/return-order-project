package com.returnordermanagementsystem.componentprocessing.service;

import com.returnordermanagementsystem.componentprocessing.request.ProcessRequest;
import com.returnordermanagementsystem.componentprocessing.response.ProcessResponse;

public interface ProcessingService {

	ProcessResponse getDetails(ProcessRequest request);
}
