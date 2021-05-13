package com.example.customer.Technical.Assessment.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.customer.Technical.Assessment.model.Customer;
import com.example.customer.Technical.Assessment.service.CustomerService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=CustomerController.class)
class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private CustomerService service;
	
	@MockBean
	private Customer customer;
	
	private int customernumber=1;
	private String json= "{\"name\" : \"Ram\", \"customernumber\" : 1}";
	
	
	private List<Customer> customerList=new ArrayList<>();
	private ResponseEntity<Customer> response=new ResponseEntity<Customer>(customer, HttpStatus.OK);
	
	
	
	@Test
	public void testAddCustomer() throws Exception {
		Mockito.when(service.addCustomer(customer)).thenReturn(response);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addcustomer", customernumber)
				.accept(MediaType.APPLICATION_JSON)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(requestBuilder).andReturn();
		int statusCode=result.getResponse().getStatus();
		assertEquals(200, statusCode);
		
		
	}
	
	
	

}
