package com.returnordermanagementsystem.componentprocessing.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="packaging-and-delivery-module", url="localhost:8000")
@FeignClient(name="packaging-and-delivery-module")
public interface PackageAndDeliveryModuleProxy {

	@GetMapping("/GetPackagingDeliveryCharge/{componentType}/{count}")
	public int getDetails(@PathVariable String componentType, @PathVariable int count);
}
