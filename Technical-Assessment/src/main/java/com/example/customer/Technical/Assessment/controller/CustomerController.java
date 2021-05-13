package com.example.customer.Technical.Assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.Technical.Assessment.model.Customer;
import com.example.customer.Technical.Assessment.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
	
	

	@Autowired
	CustomerService service;
	
	
	@PostMapping(path = "/addcustomer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		service.saveCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);		
		
	}
	
	@PutMapping("/customer")
	public void updateCustomer(@RequestBody Customer customer) {
		service.update(customer);
	}	
	
	@DeleteMapping(path = "/delete/{customernumber}", produces = "application/json")
	public void deleteCustomer(@PathVariable int  customernumber) {
		service.delete(customernumber);
	}
	
	
	@GetMapping(path = "/getcustomer/{customernumber}", produces = "application/json")
	public ResponseEntity<Customer> findByCustNmuber(@PathVariable int customernumber){
		Customer c=service.getCustomerByNumber(customernumber);
		if(c==null) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Customer>(HttpStatus.OK);
		}
	}
		
	
	@GetMapping(path = "/getcustomers", produces = "application/json")
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}	

}
