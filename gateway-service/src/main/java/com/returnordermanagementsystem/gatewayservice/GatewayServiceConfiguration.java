package com.returnordermanagementsystem.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin(origins = "*", maxAge = 3600)
public class GatewayServiceConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/CompleteProcessing/**").uri("lb://component-processing"))
				.route(p -> p.path("/ProcessDetail/**").uri("lb://component-processing"))
				.route(p -> p.path("/auth/**").uri("lb://authorization-service"))
				.build();

	}
}
