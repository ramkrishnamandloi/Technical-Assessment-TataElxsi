package com.example.customer.Technical.Assessment.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Customer")
public class Customer {

	@Id
	private int customernumber;	
	
	private String name;

	public int getCustomernumber() {
		return customernumber;
	}

	public void setCustomernumber(int customernumber) {
		this.customernumber = customernumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
