package com.returnordermanagementsystem.authorizationservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jayway.jsonpath.JsonPath;
import com.returnordermanagementsystem.authorizationservice.payload.request.LoginRequest;
import com.returnordermanagementsystem.authorizationservice.payload.request.SignupRequest;


class AuthControllerTests extends AuthorizationServiceApplicationTests {

	   @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	   
	   @Test
	   @Order(1)
	   void signupTest() throws Exception {
		  mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/auth/signup";
	      SignupRequest signupRequest = new SignupRequest();
	      signupRequest.setUsername("user1");
	      signupRequest.setRole(new HashSet<>(Arrays.asList("User")));
	      signupRequest.setEmail("user1@email.com");
	      signupRequest.setPassword("password");
	      String inputJson = super.mapToJson(signupRequest);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.message");
	      assertEquals("User registered successfully!", content);

	   }
	   
		
		  @Test
		  @Order(2) 
		  void loginTest() throws Exception { 
			  mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
			  
			  String uri1 = "/auth/signup";
		      SignupRequest signupRequest = new SignupRequest();
		      signupRequest.setUsername("user2");
		      signupRequest.setRole(new HashSet<>(Arrays.asList("User")));
		      signupRequest.setEmail("user2@email.com");
		      signupRequest.setPassword("password");
		      String inputJson1 = super.mapToJson(signupRequest);
		      mvc.perform(MockMvcRequestBuilders.post(uri1)
		         .contentType(MediaType.APPLICATION_JSON_VALUE)
		         .content(inputJson1)).andReturn();
		      
			  String uri = "/auth/signin"; 
			  LoginRequest loginRequest = new LoginRequest();
			  loginRequest.setUsername("user2"); 
			  loginRequest.setPassword("password");
			  String inputJson = super.mapToJson(loginRequest);
			  System.out.println(inputJson); 
			  MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
							  .contentType(MediaType.APPLICATION_JSON_VALUE)
							  .content(inputJson)).andReturn();
		  
			  int status = mvcResult.getResponse().getStatus(); 
			  assertEquals(200, status);
		  }
		 
}
