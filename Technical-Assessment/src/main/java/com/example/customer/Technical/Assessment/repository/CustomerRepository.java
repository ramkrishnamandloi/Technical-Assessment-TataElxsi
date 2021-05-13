package com.example.customer.Technical.Assessment.repository;

import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;

import com.example.customer.Technical.Assessment.model.Customer;

public interface CustomerRepository extends MongoRepositoryBean<Customer, Integer>{

}
