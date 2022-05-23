package com.returnordermanagementsystem.componentprocessing;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
	
	  @Bean
	  public GroupedOpenApi publicApi() {
	      return GroupedOpenApi.builder()
	              .group("springshop-public")
	              .packagesToScan("com.returnordermanagementsystem.componentprocessing")
	              .pathsToMatch("/**")
	              .build();
	  }

}
