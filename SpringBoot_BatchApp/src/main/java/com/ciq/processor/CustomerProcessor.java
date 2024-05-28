package com.ciq.processor;

import org.springframework.batch.item.ItemProcessor;

import com.ciq.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer customer) throws Exception {
		//logic
		return customer;
	}

}
