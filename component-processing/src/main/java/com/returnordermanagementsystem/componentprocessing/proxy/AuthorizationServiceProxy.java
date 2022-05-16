package com.returnordermanagementsystem.componentprocessing.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnordermanagementsystem.componentprocessing.exception.TokenInvalidException;

@FeignClient(name = "authorization-service")
public interface AuthorizationServiceProxy{
	@GetMapping("/auth/validateToken")
	public boolean validateToken(@RequestHeader("Authorization") String token) throws TokenInvalidException ;

}
