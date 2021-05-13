package com.example.customer.Technical.Assessment.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.customer.Technical.Assessment.model.Customer;
import com.example.customer.Technical.Assessment.repository.CustomerRepository;

public class CustomerService {
	
	@Autowired
	CustomerRepository repository;
	

	public void saveCustomer(Customer customer) {
		repository.save(customer);		
	}

	public void update(Customer customer) {
		repository.save(customer);
		
	}

	public void delete(int customernumber) {
		repository.deleteById(customernumber);
		
	}

	public Customer getCustomerByNumber(int customernumber) {
		
		return repository.findById(customernumber).get();
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customers=new ArrayList<>();
		repository.findAll().forEach(cust->customers.add(cust));
		return customers;
	}

}
